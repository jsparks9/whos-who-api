package com.spotify.api.services;

import com.spotify.api.dtos.AttemptRequestDto;
import com.spotify.api.dtos.AttemptResponseDto;

import java.util.List;

public interface AttemptService {
    AttemptResponseDto createAttempt(AttemptRequestDto attemptRequestDto);

    List<AttemptResponseDto> getAttemptsForUsername(String credentialsDto);
}
