package com.unip.tcc2k22;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unip.tcc2k22.models.DataSpring;
import com.unip.tcc2k22.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/insert")
public class MainController {

    @Autowired
    Repository repository;

    @GetMapping
    public String get(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<String> saveData(int limit) throws IOException {
         String text = readFile("C:\\Users\\fgmil\\IdeaProjects\\tcc2k22\\src\\main\\java\\com\\unip\\tcc2k22\\data.json");

        ObjectMapper mapper = new ObjectMapper();

        List<DataSpring> dataSpring = mapper.readValue(text, new TypeReference<List<DataSpring>>(){});
        List<DataSpring> dataToSave = new ArrayList<>();
        for(int i = 0; i < limit;i++){
            dataToSave.add(dataSpring.get(i));
        }
        long startTime = System.currentTimeMillis();
            repository.saveAll(dataToSave);
            long endTime = System.currentTimeMillis();
            return new ResponseEntity<>("That took " + (endTime - startTime) + " milliseconds saved "+limit, HttpStatus.OK);
    }

    public String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

}
