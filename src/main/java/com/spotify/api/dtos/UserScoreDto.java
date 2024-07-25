package com.spotify.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserScoreDto {
    private String username;
    private String firstName;
    private Long totalScore;
}
