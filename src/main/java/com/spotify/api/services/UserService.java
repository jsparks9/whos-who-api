package com.spotify.api.services;

import com.spotify.api.dtos.LeaderBoardRespDto;
import com.spotify.api.dtos.UserRequestDto;
import com.spotify.api.dtos.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto getUser(String username);

    List<LeaderBoardRespDto> getTopLeaderboard(int topN);
}
