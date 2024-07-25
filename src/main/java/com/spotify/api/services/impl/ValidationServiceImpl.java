package com.spotify.api.services.impl;

import com.spotify.api.dtos.SettingsDto;
import com.spotify.api.entitites.User;
import com.spotify.api.exceptions.BadRequestException;
import com.spotify.api.exceptions.NotFoundException;
import com.spotify.api.repositories.UserRepository;
import com.spotify.api.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidateService {

    private final UserRepository userRepository;

    public void validateUserForCreation(User user) {
        if (user != null) {
            throw new BadRequestException("User already exists");
        }
    }

    public void validateUser(User user) {
        if (user == null) {
            throw new NotFoundException("User was not found");
        }
    }

    public void validateSettings(SettingsDto settingsDto) {
        if (settingsDto == null) {
            throw new BadRequestException("Settings does not exist");
        }
    }
}
