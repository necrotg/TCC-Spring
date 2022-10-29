package com.unip.tcc2k22;

import com.unip.tcc2k22.models.DataSpring;
import com.unip.tcc2k22.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/data")
public class MainController {

    @Autowired
    Repository repository;

    @GetMapping
    public String get(){

        return "OK";
    }

    @PostMapping
    public String saveData(@RequestBody List<DataSpring> dataSprings){
            long startTime = System.currentTimeMillis();
            repository.saveAll(dataSprings);
            long endTime = System.currentTimeMillis();
        return "That took " + (endTime - startTime) + " milliseconds";
    }

}
