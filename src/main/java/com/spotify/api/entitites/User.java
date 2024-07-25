package com.spotify.api.entitites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Table(name = "\"user\"")
@NoArgsConstructor
@Entity
@Data
public class User{

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Credentials credentials;

    @Embedded
    private Profile profile;

    @Embedded
    private Settings settings;

    @CreationTimestamp
    private Timestamp joined;

    @OneToMany(mappedBy = "user")
    private List<Attempt> attempts;

    private Boolean deleted = false;



}
