package com.spotify.api.mappers;

import com.spotify.api.dtos.CredentialsDto;
import com.spotify.api.entitites.Credentials;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
    Credentials dtoToEntity(CredentialsDto credentialsDto);
    CredentialsDto entityToDto(Credentials credentials);
}
