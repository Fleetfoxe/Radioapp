package com.example.radioapp.controllers;

import com.example.radioapp.entities.Category;
import com.example.radioapp.entities.Program;
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

    @GetMapping("/rest/sr/categories/program/names")
    public List<Program> getAllCategoriesApi() {
        return programService.getAllProgramNamesFromSr();
    }
}