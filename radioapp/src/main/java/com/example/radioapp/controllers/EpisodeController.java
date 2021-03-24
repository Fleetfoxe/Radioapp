package com.example.radioapp.controllers;

import com.example.radioapp.entities.Episode;
import com.example.radioapp.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;

    //Userstory 8
    @GetMapping("/rest/episodes/{programId}")
    public List<Episode> getById(@PathVariable String programId) {
        return episodeService.getEpisodeByProgramIdFromSR(programId);
    }
    //Same same just more advanced (Specified)
    //channelDate example 2021-01-25 ---> Postman
    @RequestMapping("rest/episodes/{channelId}/{channelDate}")
    public List<Episode> getByChannel(@PathVariable String channelId,@PathVariable String channelDate){

        return episodeService.getEpisodesOnChannelId(channelId,channelDate);
    }

}
