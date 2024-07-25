package com.spotify.api.repositories;

import com.spotify.api.entitites.Playlist;
import com.spotify.api.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Playlist findByName(String name);

    List<Playlist> findAllByUser(User user);

    List<Playlist> findAllByName(String name);
}
