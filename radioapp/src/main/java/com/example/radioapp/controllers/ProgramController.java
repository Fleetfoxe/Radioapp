package com.example.radioapp.controllers;

import com.example.radioapp.entities.Category;
import com.example.radioapp.entities.Program;
import com.example.radioapp.entities.User;
import com.example.radioapp.services.CategoryService;
import com.example.radioapp.services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @GetMapping("/rest/programs/category/{id}")
    public List<Program> getProgramsByCategoryById(@PathVariable long id) {
        return programService.getAllProgramNamesFromSrById(id);
    }

    //Get all programs
    @GetMapping("/rest/programs")
    public List<Program> getAllProgramsFromSR() {
        return programService.getAllProgramFromSr();
    }

    @GetMapping("/rest/programs/{name}")
    public List<Program> findProgram(@PathVariable String name) {
        return programService.getProgramFromSr(name);
    }

    //All program on a channel with name
    @GetMapping("/rest/programs/channel/{id}")
    public List<Program> getProgramsOnChannel(@PathVariable long id) {
        return programService.getProgramsOnChannel(id);
    }

    //get user by ID
    @GetMapping("/rest/programs/id/{id}")
    public Program getProgramById(@PathVariable long id){
        return programService.getProgramById(id);
    }

/*
    @GetMapping("/rest/categories/{id}")
    public Category getCategoryById(@PathVariable long id){
        return categoryService.getById(id);
    }*/
}