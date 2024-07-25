package com.spotify.api.entitites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Song {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlist;

    private String name;

    private String artist;

    private String album;

    private String albumCover;

    private String trackId;

    private String previewUrl;




}
