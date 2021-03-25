package com.example.radioapp.services;


import com.example.radioapp.entities.Category;
import com.example.radioapp.entities.Program;
import com.example.radioapp.repositories.CategoryRepo;
import com.example.radioapp.repositories.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.*;
import java.util.List;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepo programRepo;

    //http://api.sr.se/api/v2/programs/index?channelid=164&programcategoryid - get all the program names and what category
    // indent=false&size=25&page=4  -- to get all pages??

    //----------------------------------------------------------------------------------------------
    // 1. create a string variable and insert the API address to access it.
    // 2. create a method that will return a list of the given class.
    // 3. Create a RestTemplate object to handle objects/data from given API.
    // 4. Map? use template method to get objects from the given API.
    // 5. ??? ---> Point at "programcategories" in the given API
    // 6. return Listed and Converted data from API.

    private String programApi = "http://api.sr.se/api/v2/programs/index?format=json&programcategoryid=";

    public List<Program> getAllProgramNamesFromSrById(long id) {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(programApi + id, Map.class);

        List<Map> programMaps = (List<Map>)response.get("programs");

        if(programMaps==null) return null;

        List<Program> programs = new ArrayList<>();

        for (Map program : programMaps){

            Map programCategory = (Map) program.get("programcategory");
            Map channelInfo = (Map) program.get("channel");

            Program program1 = new Program(
                    (int) channelInfo.get("id"),
                    (String) channelInfo.get("name"),
                    (int) programCategory.get("id"),
                    (int) program.get("id"),
                    (String)program.get("name"),
                    (String)program.get("description"),
                    (String)program.get("programurl"),
                    (String)program.get("programimage")
            );

            programs.add(program1);

        }

        return programs;
    }



    private String allProgramApi = "http://api.sr.se/api/v2/programs?format=json&indent=false&size=25&page=10";

    public List<Program> getAllProgramFromSr() {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(allProgramApi, Map.class);

        List<Map> programMaps = (List<Map>)response.get("programs");

        if(programMaps==null) return null;

        List<Program> programs = new ArrayList<>();

        for (Map program : programMaps){

            Map programCategory = (Map) program.get("programcategory");

            //LIFEHACK
            int catId = 0;
            if (programCategory != null){
                catId = (int) programCategory.get("id");
            }
            Map channelInfo = (Map) program.get("channel");

            Program program1 = new Program(
                    (int) channelInfo.get("id"),
                    (String) channelInfo.get("name"),
                    catId,
                    (int) program.get("id"),
                    (String)program.get("name"),
                    (String)program.get("description"),
                    (String)program.get("programurl"),
                    (String)program.get("programimage")
            );

            programs.add(program1);

        }

        return programs;
    }

// USER STORY 6 AND 7
    public List<Program> getProgramFromSr(String pName) {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(allProgramApi, Map.class);

        List<Map> programMaps = (List<Map>)response.get("programs");


        if(programMaps==null) return null;

        List<Program> programs = new ArrayList<>();

        for (Map program : programMaps) {

            Map programCategory = (Map) program.get("programcategory");

            String programName = (String) program.get("name");

            if (programName.contains(pName)) {
                //LIFEHACK -if there is no category programId=0
                int catId = 0;
                if (programCategory != null) {
                    catId = (int) programCategory.get("id");
                }

                Map channelInfo = (Map) program.get("channel");

                Program program1 = new Program(
                        (int) channelInfo.get("id"),
                        (String) channelInfo.get("name"),
                        catId,
                        (int) program.get("id"),
                        programName,
                        (String)program.get("description"),
                        (String)program.get("programurl"),
                        (String)program.get("programimage")

                );

                programs.add(program1);
            }

        }

        return programs;
    }

    private String allProgramOnChannelApi="http://api.sr.se/api/v2/programs/index?format=json&channelid=";

    public List<Program> getProgramsOnChannel(long id) {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(allProgramOnChannelApi+id, Map.class);

        List<Map> programMaps = (List<Map>)response.get("programs");


        if(programMaps==null) return null;

        List<Program> programs = new ArrayList<>();

        for (Map program : programMaps) {

            Map programCategory = (Map) program.get("programcategory");
            int catId = 0;
            //LIFEHACK
            if (programCategory != null) { catId = (int) programCategory.get("id"); }

            Map channelInfo = (Map) program.get("channel");

            Program program1 = new Program(
                    (int) channelInfo.get("id"),
                    (String) channelInfo.get("name"),
                    catId,
                    (int) program.get("id"),
                    (String) program.get("name"),
                    (String) program.get("description"),
                    (String) program.get("programurl"),
                    (String) program.get("programimage")
            );

            programs.add(program1);
        }

        return programs;
    }


}
