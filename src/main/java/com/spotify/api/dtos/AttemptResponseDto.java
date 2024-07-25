package com.spotify.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
public class AttemptResponseDto {
    @NonNull
    private Integer score;

    @NonNull
    private String albumName;

    @NonNull
    private String artistName;

    @NonNull
    private String albumCover;

    @NonNull
    private String taken;
}
