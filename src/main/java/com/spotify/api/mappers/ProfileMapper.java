package com.spotify.api.mappers;

import com.spotify.api.dtos.ProfileDto;
import com.spotify.api.entitites.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile dtoToEntity(ProfileDto profileDto);
    ProfileDto entityToDto(Profile profile);
}
