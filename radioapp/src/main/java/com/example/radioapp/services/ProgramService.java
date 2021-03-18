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

    private String programApi = "http://api.sr.se/api/v2/programs/index?channelid=164&programcategoryid?format=json";

    public List<Program> getAllProgramNamesFromSr() {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(programApi, Map.class);

        List<Program> programs = (List<Program>) response.get("programs");

        return programs;
    }
}