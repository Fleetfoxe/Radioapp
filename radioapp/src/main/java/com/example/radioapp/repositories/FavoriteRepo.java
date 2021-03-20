package com.example.radioapp.repositories;

import com.example.radioapp.entities.Episode;
import com.example.radioapp.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
    boolean existsFavoriteByEpisode(long episode);
}
