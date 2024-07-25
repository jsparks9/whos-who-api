package com.spotify.api.services.impl;

import com.spotify.api.dtos.SongDto;
import com.spotify.api.dtos.playlist.PlaylistRequestDto;
import com.spotify.api.dtos.playlist.PlaylistResponseDto;
import com.spotify.api.entitites.Playlist;
import com.spotify.api.entitites.User;
import com.spotify.api.mappers.PlaylistMapper;
import com.spotify.api.repositories.PlaylistRepository;
import com.spotify.api.repositories.SongRepository;
import com.spotify.api.services.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final UserServiceImpl userService;
    private final ValidationServiceImpl validationService;
    private final PlaylistMapper playlistMapper;
    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    @Override
    public List<PlaylistResponseDto> getPlaylists() {
        return playlistMapper.entitiesToDtos(playlistRepository.findAll());
    }

    @Override
    public List<PlaylistResponseDto> getPlaylistsForUsername(String username) {
        User user = userService.getUserByUsername(username);
        validationService.validateUser(user);

        return playlistMapper.entitiesToDtos(playlistRepository.findAllByUser(user));
    }

    @Override
    public List<PlaylistResponseDto> getPlaylist(String name) {
        return playlistMapper.entitiesToDtos(playlistRepository.findAllByName(name));
    }

    @Override
    public PlaylistResponseDto createPlaylist(PlaylistRequestDto playlistDto) {
        User user = userService.getUserByUsername(playlistDto.getCredentials().getUsername());
        validationService.validateUser(user);
        Playlist playlist = playlistMapper.dtoToEntity(playlistDto);
        playlist.setUser(user);
        playlist.setCreatedBy(user.getCredentials().getUsername());
        playlist.getSongs().forEach(song -> song.setPlaylist(List.of(playlist)));

        songRepository.saveAll(playlist.getSongs());

        return playlistMapper.entityToDto(playlistRepository.saveAndFlush(playlist));
    }

    @Override
    public PlaylistResponseDto updatePlaylist(String id, PlaylistRequestDto playlistDto) {
        return null;
    }

    @Override
    public void deletePlaylist(String id) {

    }

    @Override
    public PlaylistResponseDto addTrack(String id, SongDto SongDto) {
        return null;
    }

    @Override
    public PlaylistResponseDto deleteTrack(String id, String trackId) {
        return null;
    }

    @Override
    public List<SongDto> getTracks(String id) {
        return null;
    }

    @Override
    public SongDto getTrack(String id, String trackId) {
        return null;
    }

    @Override
    public SongDto updateTrack(String id, String trackId, SongDto songDto) {
        return null;
    }


}
