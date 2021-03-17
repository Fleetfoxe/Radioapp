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

    @GetMapping("/hello")
    public String helloworld() {
        return "Hello World!";
    }

    @GetMapping("/rest/channels")
    public List<Channel> getAllChannels() {
        return channelService.getAll();
    }

    @GetMapping("/rest/sr/channels")
    public List<Channel> getAllChannelsSR() {
        return channelService.getAllChannelsFromSR();
    }

    @GetMapping("/rest/sr/ch2")
    public List<Channel> getConvertedChannels() {
        return channelService.getChannelsV2();
    }


}
