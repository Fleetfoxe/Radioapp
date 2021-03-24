package com.example.radioapp.services;

import com.example.radioapp.entities.Channel;
import com.example.radioapp.repositories.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepo channelRepo;

    private String channelApi = "http://api.sr.se/api/v2/channels?format=json";

    public List<Channel> getChannelsCleaned() {
        RestTemplate template = new RestTemplate();

        // convert response to a Map
        Map response = template.getForObject(channelApi, Map.class);

        // for easy extraction of the results data
        List<Map> channelMaps = (List<Map>) response.get("channels");

        // if no match, return null
        if(channelMaps == null) return null;

        List<Channel> channels = new ArrayList<>();

        // loop all channels and extract the data we want
        for(Map channel : channelMaps) {

            // create a channel object with extracted data
            Channel channel1 = new Channel(

                    Long.valueOf((int)channel.get("id")),    // id
                    (String)channel.get("name"),                   // name
                    (String)channel.get("image"),                   // image url
                    (String)channel.get("scheduleurl")                   //
            );

            // populate list with freshly created channels
            channels.add(channel1);
        }
        return channels;
    }


    public List<Channel> getAll() {
        return channelRepo.findAll();
    }

}
