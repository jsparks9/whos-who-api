package com.spotify.api.dtos.playlist;

import com.spotify.api.dtos.SongDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Data
public class PlaylistResponseDto {
    private Timestamp created;
    private List<SongDto> songs;
    private String name;
    private String createdBy;
}
