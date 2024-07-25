package com.spotify.api.repositories;

import com.spotify.api.entitites.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long>{
}
