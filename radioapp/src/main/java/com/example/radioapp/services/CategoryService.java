package com.example.radioapp.services;


import com.example.radioapp.entities.*;
import com.example.radioapp.entities.Program;
import com.example.radioapp.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    //---------------------------------- USER STORY 4 backend   --------------------------------------------------------

    // 1. create a string variable and insert the API address to access it.
    // 2. create a method that will return a list of objects from the given class.
    // 3. Create a RestTemplate object to handle objects/data from given API.
    // 4. Map uses the template method to get objects from the given API.
    // 5. Point at "programcategories" in the given API to get the data/objects and insert it in variable categories.
    // 6. return Listed and Converted data from API.

    private String categoryApi = "http://api.sr.se/api/v2/programcategories?format=json";

    public List<Category> getAllCategoriesFromSr() {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(categoryApi, Map.class);

        List<Category> categories = (List<Category>) response.get("programcategories");

        return categories;
    }
    public List<Category> getAll() {
       return categoryRepo.findAll();
    }
}


