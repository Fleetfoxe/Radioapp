package com.example.radioapp.services;


import com.example.radioapp.entities.Category;
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

    private String categoryApi = "http://api.sr.se/api/v2/programcategories?format=json";

    public List<Category> getAllCategoriesFromSr() {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(categoryApi, Map.class);

        List<Category> categories = (List<Category>) response.get("programcategories");

        return categories;
    }

/*  IFALL ---> SPARA TILL DB
    public List<Category> getCategories() {

        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(categoryApi, Map.class);

        List<Map> categoryMaps = (List<Map>) response.get("sr");

        if(categoryMaps == null) return null;

        List<Category> categories = new ArrayList<>();

        for(Map category : categoryMaps) {


            Category categoryExtract = new Category(

                    Long.valueOf((int)category.get("id")),
                    (String)category.get("name")
            );

            categories.add(categoryExtract);


        }


        categories.forEach((n) -> categoryRepo.save(n));

        return categories;
    }
*/

    public List<Category> getAll() {
        return categoryRepo.findAll();
    }


    public Category getById(long id){
        Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        return null;
    }

}
