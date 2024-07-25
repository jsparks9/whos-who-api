package com.spotify.api.controllers;

import com.spotify.api.dtos.SettingsDto;
import com.spotify.api.dtos.UserResponseDto;
import com.spotify.api.services.SettingsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/settings")
public class SettingsController {

    private final SettingsService settingsService;

    @PutMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto updateSettings(
            @PathVariable("username") String username,
            @RequestBody @Valid SettingsDto settingsDto
    ) {
        return settingsService.updateSettings(username, settingsDto);
    }
}
