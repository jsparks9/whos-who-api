package com.spotify.api.controllers;

import com.spotify.api.dtos.LeaderBoardRespDto;
import com.spotify.api.dtos.UserRequestDto;
import com.spotify.api.dtos.UserResponseDto;
import com.spotify.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @GetMapping("/leaderboard/{topN}")
    @ResponseStatus(HttpStatus.OK)
    public List<LeaderBoardRespDto> getTopLeaderboard(
            @PathVariable("topN") int topN
    ) {
        return userService.getTopLeaderboard(topN);
    }


}
