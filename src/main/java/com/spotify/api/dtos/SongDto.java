package com.spotify.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SongDto {
    private String name;
    private String artist;
    private String album;
    private String trackId;
    private String albumCover;
    private String previewUrl;
}
