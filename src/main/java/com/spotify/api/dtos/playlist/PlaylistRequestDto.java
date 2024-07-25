package com.spotify.api.dtos.playlist;

import com.spotify.api.dtos.CredentialsDto;
import com.spotify.api.entitites.Song;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PlaylistRequestDto {
    private CredentialsDto credentials;
    private String name;
    private List<Song> songs;
}
