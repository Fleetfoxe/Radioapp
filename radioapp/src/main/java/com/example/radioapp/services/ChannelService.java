package com.example.radioapp.services;

import com.example.radioapp.repositories.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepo channelRepo;


}
