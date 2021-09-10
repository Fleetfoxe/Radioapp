package com.example.radioapp.services;


import com.example.radioapp.entities.Category;
import com.example.radioapp.entities.Favorite;
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
    @Autowired
    private UserService userService;

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


    //-------------- User story 5 -----------------------
    // 1. create a string variable and insert the API address to access it.
    // 2. create a method that will return a list of the given class.
    // 3. Create a RestTemplate object to handle objects/data from given API.
    // 4. Map use template method to get objects from the given API.
    // 5. Point at "programcategory" in the given API to get the object
    // 6. return Listed and Converted data from API.

    private String allProgramApi = "http://api.sr.se/api/v2/programs/?format=json&pagination=false";

    public List<Program> getAllProgramFromSr() {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(allProgramApi, Map.class);

        List<Map> programMaps = (List<Map>)response.get("programs");

        if(programMaps==null) return null;

        List<Program> programs = new ArrayList<>();

        for (Map program : programMaps){

            Map programCategory = (Map) program.get("programcategory");

            // LIFEHACK
            // Makes sure that you can take out a variable and work with it before putting it back on its place.
            // The reason why we do this is because som programs does not have a category. These category-less programs
            // will return 0. However if it has a category it will get its "id".
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

// USER STORY 6 AND 7 (Search program by name)
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

    //Here is a method for getting a program as an object based on ID
    //It does not return a list like other methods using external APIs

    private String programByIdUrl= "http://api.sr.se/api/v2/programs/";

    public Program getProgramById(long id) {
        //URL: http://api.sr.se/api/v2/programs/1120?format=json

        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(programByIdUrl + id + "?format=json", Map.class);

        //Debug
        System.out.println("ProgramService getProgramById - Response from SR: " + response);

        //Mapping the object program inside the response
        Map programMap = (Map) response.get("program");

        //Creating a program object and adding things from the mapped response from SR

        Program program = new Program(
                (int) programMap.get("id"),
                (String) programMap.get("name"),
                (String) programMap.get("description"),
                (String) programMap.get("programimage")
                );

        return program;
    }

    public List<Program> showMyFavoritePrograms() {

        //Gets a list of favorite objects by using the showMyFavorites method
        List<com.example.radioapp.entities.Favorite> favorites = userService.showMyFavorites();

        //Creates a list of long variables to store program ids in
        List<Long> listOfFavProgramIds = new ArrayList<Long>();

        //Loops through the list of favorite objects and puts the program ids into list of long variables
        for (Favorite favorite : favorites) {
            if (favorite.getProgramId() != 0 ) {
                listOfFavProgramIds.add(favorite.getProgramId());
            }
        }

        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(allProgramApi, Map.class);

        List<Map> programMaps = (List<Map>)response.get("programs");

        if(programMaps==null) return null;

        List<Program> programs = new ArrayList<>();

        //Loops through the list of programIds from the favorites
        for (long favProgramId : listOfFavProgramIds) {

            //Loops through all programs from SR
            for (Map program : programMaps) {
                int programId = (int) program.get("id");

                //checks if program id from favorite and program id is the same
                if (favProgramId == programId) {

                    Map programCategory = (Map) program.get("programcategory");
                    String programName = (String) program.get("name");

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
                                (String) program.get("description"),
                                (String) program.get("programurl"),
                                (String) program.get("programimage")
                        );
                    programs.add(program1);
                }
            }
        }
        return programs;
    }



}
