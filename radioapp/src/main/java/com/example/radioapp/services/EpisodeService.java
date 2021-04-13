package com.example.radioapp.services;

import com.example.radioapp.entities.Episode;
import com.example.radioapp.repositories.EpisodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EpisodeService {
    @Autowired
    private EpisodeRepo episodeRepo;
    private String episodeApi = "http://api.sr.se/api/v2/episodes/index?format=json&programid=";
    private String episodeApiChannels = "http://api.sr.se/api/v2/scheduledepisodes?format=json&channelid=";

    public List<Episode> getEpisodeByProgramIdFromSR(String programId) {
        RestTemplate template = new RestTemplate();

        Map response = template.getForObject(episodeApi+programId, Map.class);

        List<Map> episodeMaps = (List<Map>)response.get("episodes");

        if(episodeMaps==null) return null;

        List<Episode> episodes= new ArrayList<>();

        for(Map episode :episodeMaps){
            //create a episode object with extracted data
            // id, title, starttimeutc, endtimeutc, program, channel, imageurl

            
            Map broadcastTime=(Map) episode.get("broadcasttime");

            // STEP 1:
           String date = (String) broadcastTime.get("starttimeutc"); // Insert broadcast.get("start time utc") in string variable = date
           System.out.println(date); // Test date

            // STEP 2: Endast få ut siffror från date + sätt in i ny variabel (int, long) SIMPLE DATE FORMAT
           String digitsOnly = date.replaceAll("[^0-9]", ""); // Only extracts digits from date (String)
           System.out.println(digitsOnly); // Test so that we only get the digits from string

            // STEP 3: Create a long variable and declare it with String digitsOnly and parse it to long.
            long longDigits = Long.parseLong(digitsOnly);

            // STEP 4: insert long variable in object
            Episode episode1= new Episode(
                    (int) episode.get("id"),
                    (String)episode.get("title"),
                    longDigits,
                    (String)broadcastTime.get("endtimeutc"),
                    //(int)episode.get("channelid"),    We can't make this work, returns null value
                    (String)episode.get("imageurl")
                    );

            episodes.add(episode1);

        }
        System.out.println(episodes);
        return episodes;

    }
    //Send two inputs in the parameters otherwise the same
    public List<Episode> getEpisodesOnChannelId(String channelId,String channelDate){
        RestTemplate template = new RestTemplate();

        //"&date=" ---> modify API to get return requested data
        Map response = template.getForObject(episodeApiChannels + channelId +"&date="+ channelDate,Map.class);

        List<Map> episodeMaps = (List<Map>)response.get("schedule");
        if(episodeMaps==null) return null;
        System.out.println(episodeMaps);
        List<Episode> episodes = new ArrayList<>();

        for(Map episode: episodeMaps){


            // STEP 1:
            String date = (String) episode.get("starttimeutc"); // Insert broadcast.get("start time utc") in string variable = date
            System.out.println(date); // Test date

            // STEP 2: Endast få ut siffror från date + sätt in i ny variabel (int, long) SIMPLE DATE FORMAT
            String digitsOnly = date.replaceAll("[^0-9]", ""); // Only extracts digits from date (String)
            System.out.println(digitsOnly); // Test so that we only get the digits from string

            long longDigits = Long.parseLong(digitsOnly);


            //If episodeId is missing = we don´t get it
            if(episode.get("episodeid")!=null){

                Episode episode1 = new Episode(

                        (long) (int) episode.get("episodeid"),
                        (String) episode.get("title"),
                        longDigits,
                        (String) episode.get("endtimeutc"),
                        (String) episode.get("imageurl")

                );
            System.out.println(episode1);
            episodes.add(episode1);
        }
            };

        System.out.println(episodes);
        return episodes;


    }

    

}
