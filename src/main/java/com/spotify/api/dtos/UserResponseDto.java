package com.spotify.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class UserResponseDto {
    @NonNull
    private String username;

    @NonNull
    private ProfileDto profile;

    @NonNull
    private Timestamp joined;

    @NonNull
    private SettingsDto settings;
}
