package com.example.radioapp.repositories;


import com.example.radioapp.entities.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepo extends JpaRepository<Episode,Long>  {

}

