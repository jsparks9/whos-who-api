package com.spotify.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class LeaderBoardRespDto {
    @NonNull
    private String username;

    @NonNull
    private String firstName;

    private long score;
}
