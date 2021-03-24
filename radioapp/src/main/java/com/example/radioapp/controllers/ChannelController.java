package com.example.radioapp.controllers;

import com.example.radioapp.entities.Channel;
import com.example.radioapp.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @GetMapping("/rest/channels")
    public List<Channel> getAllChannelsFromDB() {
        return channelService.getAll();
    }

    @GetMapping("/rest/channels")
    public List<Channel> getAllChannelsSR() {
        return channelService.getAllChannelsFromSR();
    }

    @GetMapping("/rest/channelscleaned")
    public List<Channel> getAllChannelsSRcleaned() {
        return channelService.getChannelsCleaned();
    }
}
