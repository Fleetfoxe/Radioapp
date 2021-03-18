package com.example.radioapp.services;

import com.example.radioapp.entities.Episode;
import com.example.radioapp.repositories.EpisodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

        List<Episode> episodes = (List<Episode>)response.get("episodes");

        return episodes;
    }



}
