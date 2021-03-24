package com.example.radioapp.controllers;

import com.example.radioapp.entities.Category;
import com.example.radioapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;



    @GetMapping("/rest/categories")
    public List<Category> getAllCategoriesApi() {
        return categoryService.getAllCategoriesFromSr();
    }


   // @GetMapping("/rest/categories/{id}")
   // public Category getCategoryById(@PathVariable long id){
   //     return categoryService.getById(id);
   // }

}

