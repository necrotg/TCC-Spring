package com.unip.tcc2k22;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unip.tcc2k22.models.DataSpring;
import com.unip.tcc2k22.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    public String saveData() throws IOException {
         String text = readFile("C:\\Users\\fgmil\\IdeaProjects\\tcc2k22\\src\\main\\java\\com\\unip\\tcc2k22\\data.json");
            long startTime = System.currentTimeMillis();
        ObjectMapper mapper = new ObjectMapper();
        List<DataSpring> dataSprings = mapper.readValue(text, new TypeReference<List<DataSpring>>(){});
            repository.saveAll(dataSprings);
            long endTime = System.currentTimeMillis();
        return "That took " + (endTime - startTime) + " milliseconds";
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
