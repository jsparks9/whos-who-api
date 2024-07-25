package com.spotify.api.entitites;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Embeddable
@Data
public class Settings {
    private String difficulty = "Easy";  // TODO : Switch to ENUM
    private int timeLimit = 0;  // 0 means no time limit
    private String responseType = "Multiple";  // TODO : Switch to ENUM
    private List<String> genre = new ArrayList<>();  // Empty for all genre
    private Boolean hints = false;
}
