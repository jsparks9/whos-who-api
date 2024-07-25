package com.spotify.api.mappers;

import com.spotify.api.dtos.AttemptRequestDto;
import com.spotify.api.dtos.AttemptResponseDto;
import com.spotify.api.entitites.Attempt;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttemptMapper {
    AttemptResponseDto entityToResponseDto(Attempt attempt);
    Attempt requestDtoToEntity(AttemptRequestDto attemptRequestDto);
    List<AttemptResponseDto> entityListToResponseDtoList(List<Attempt> attempts);


}
