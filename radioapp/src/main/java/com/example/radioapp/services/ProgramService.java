package com.example.radioapp.services;


import com.example.radioapp.entities.Category;
import com.example.radioapp.entities.Program;
import com.example.radioapp.repositories.CategoryRepo;
import com.example.radioapp.repositories.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepo programRepo;

    //http://api.sr.se/api/v2/programs/index?channelid=164&programcategoryid - get all the program names and what category

    private String programApi = "http://api.sr.se/api/v2/programs/index?format=json&programcategoryid=";

    public List<Program> getAllProgramNamesFromSr(long id) {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(programApi + id, Map.class);

        //List<Program> programs = (List<Program>) response.get("programs");

        List<Map> programMaps = (List<Map>)response.get("programcategory");

        if(programMaps==null) return null;

        List<Program> programs = new ArrayList<>();

        for (Map program : programMaps){

            Map programCategory = (Map) program.get("programcategory");
            List<Long> idSr = (List<Long>) programCategory.get("id");
            List<String> nameSr = (List<String>) programCategory.get("name");

            Program program1 = new Program(
                    (String)program.get("description"),
                    idSr.get(1),
                    nameSr.get(1),
                    (String)program.get("programurl")
            );

            programs.add(program1);

        }

        return programs;
    }
}