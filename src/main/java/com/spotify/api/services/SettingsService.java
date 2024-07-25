package com.spotify.api.services;

import com.spotify.api.dtos.SettingsDto;
import com.spotify.api.dtos.UserResponseDto;

public interface SettingsService {
    UserResponseDto updateSettings(String username, SettingsDto settingsDto);
}
