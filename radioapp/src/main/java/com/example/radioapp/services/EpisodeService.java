package com.example.radioapp.services;

import com.example.radioapp.entities.Episode;
import com.example.radioapp.repositories.EpisodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EpisodeService {
    @Autowired
    private EpisodeRepo episodeRepo;
    private String episodeApi = "http://api.sr.se/api/v2/episodes/index?format=json&programid=";

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
            System.out.println((String)broadcastTime.get("starttimeutc"));
            Episode episode1= new Episode(
                    (long) (int) episode.get("id"),
                    (String)episode.get("title"),
                    (String)broadcastTime.get("starttimeutc"),
                    (String)broadcastTime.get("endtimeutc"),
                    //(int)episode.get("channelid"),    We can't make this work, returns null value
                    (String)episode.get("imageurl")
                    );

            // How to convert date format to string
            //((String)broadcastTime.get("starttimeutc")).replaceFirst("^.*Date\\((\\d+)\\).*$", "$1"),

            episodes.add(episode1);

        }
        System.out.println(episodes);
        return episodes;

    }



}
