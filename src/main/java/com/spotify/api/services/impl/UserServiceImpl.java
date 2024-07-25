package com.spotify.api.services.impl;

import com.spotify.api.dtos.LeaderBoardRespDto;
import com.spotify.api.dtos.UserRequestDto;
import com.spotify.api.dtos.UserResponseDto;
import com.spotify.api.entitites.User;
import com.spotify.api.mappers.UserMapper;
import com.spotify.api.repositories.UserRepository;
import com.spotify.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ValidationServiceImpl validationService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = getUserByUsername(userRequestDto.getCredentials().getUsername());
        validationService.validateUserForCreation(user);
        System.out.println(userRequestDto);
        return userMapper.entityToResponseDto(userRepository.saveAndFlush(userMapper.requestDtoToEntity(userRequestDto)));
    }

    @Override
    public UserResponseDto getUser(String username) {
        User user = getUserByUsername(username);
        validationService.validateUser(user);
        return userMapper.entityToResponseDto(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByCredentialsUsername(username);
    }

    @Override
    public List<LeaderBoardRespDto> getTopLeaderboard(int topN) {
        return userRepository.getTopScorers(PageRequest.of(0,topN));
    }

}
