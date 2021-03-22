package com.example.radioapp.repositories;

import com.example.radioapp.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {

}
