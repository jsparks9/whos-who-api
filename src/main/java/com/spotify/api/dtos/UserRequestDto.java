package com.spotify.api.dtos;

import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequestDto {

    @Embedded
    private CredentialsDto credentials;

    @Embedded
    private ProfileDto profile;

    @Embedded
    private SettingsDto settings;
}
