package com.spotify.api.mappers;

import com.spotify.api.dtos.UserRequestDto;
import com.spotify.api.dtos.UserResponseDto;
import com.spotify.api.entitites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialsMapper.class, SettingsMapper.class, PlaylistMapper.class})
public interface UserMapper {
    @Mapping(target = "username", source = "credentials.username")
    UserResponseDto entityToResponseDto(User user);
    User requestDtoToEntity(UserRequestDto userDto);
    List<User> requestDtosToEntities(List<UserRequestDto> userDtos);
    List<UserResponseDto> entitiesToResponseDtos(List<User> users);
}
