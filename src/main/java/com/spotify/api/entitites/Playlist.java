package com.spotify.api.entitites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Playlist {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private Timestamp created;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
        name = "playlist_songs",
        joinColumns = @JoinColumn(name = "playlist_id"),
        inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;

    private String name;
    private String createdBy;

}
