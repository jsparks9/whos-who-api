package com.spotify.api.mappers;

import com.spotify.api.dtos.SongDto;
import com.spotify.api.entitites.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {

    SongDto entityToDto(Song song);
    Song dtoToEntity(SongDto songDto);


}
