package com.spotify.api.mappers;

import com.spotify.api.dtos.playlist.PlaylistRequestDto;
import com.spotify.api.dtos.playlist.PlaylistResponseDto;
import com.spotify.api.entitites.Playlist;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SongMapper.class})
public interface PlaylistMapper {

         PlaylistResponseDto entityToDto(Playlist playlist);
         Playlist dtoToEntity(PlaylistRequestDto playlistDto);

         List<PlaylistResponseDto> entitiesToDtos(List<Playlist> playlists);
}
