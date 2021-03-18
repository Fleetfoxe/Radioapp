package com.example.radioapp.controllers;

import com.example.radioapp.entities.Episode;
import com.example.radioapp.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


}
