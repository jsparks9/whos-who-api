package com.spotify.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AttemptRequestDto {
    private CredentialsDto credentials;
    private String score;
    private String albumName;
    private String artistName;
    private String albumCover;
}
