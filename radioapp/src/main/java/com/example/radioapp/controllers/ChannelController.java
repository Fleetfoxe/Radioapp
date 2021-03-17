package com.example.radioapp.controllers;

import com.example.radioapp.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @GetMapping("/hello")
    public String helloworld() {
        return "Hello World!";
    }

}
