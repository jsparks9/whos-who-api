package com.spotify.api.entitites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
public class Attempt {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private Timestamp taken;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    private Integer score;

    private String albumName;

    private String artistName;

    private String albumCover;

}
