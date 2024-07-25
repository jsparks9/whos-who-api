package com.spotify.api.services.impl;

import com.spotify.api.dtos.SettingsDto;
import com.spotify.api.dtos.UserResponseDto;
import com.spotify.api.entitites.User;
import com.spotify.api.mappers.SettingsMapper;
import com.spotify.api.mappers.UserMapper;
import com.spotify.api.repositories.UserRepository;
import com.spotify.api.services.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingsService {

    private final UserServiceImpl userService;
    private final ValidationServiceImpl validationService;
    private final SettingsMapper settingsMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto updateSettings(String username, SettingsDto settingsDto) {
        User user = userService.getUserByUsername(username);
        validationService.validateUser(user);
        validationService.validateSettings(settingsDto);

        user.setSettings(settingsMapper.dtoToEntity(settingsDto));

        return userMapper.entityToResponseDto(userRepository.saveAndFlush(user));
    }
}
