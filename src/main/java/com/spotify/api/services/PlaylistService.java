package com.spotify.api.services;

import com.spotify.api.dtos.SongDto;
import com.spotify.api.dtos.playlist.PlaylistRequestDto;
import com.spotify.api.dtos.playlist.PlaylistResponseDto;

import java.util.List;

public interface PlaylistService {
    List<PlaylistResponseDto> getPlaylists();

    List<PlaylistResponseDto> getPlaylist(String id);

    PlaylistResponseDto createPlaylist(PlaylistRequestDto playlistDto);

    PlaylistResponseDto updatePlaylist(String id, PlaylistRequestDto playlistDto);

    void deletePlaylist(String id);

    PlaylistResponseDto addTrack(String id, SongDto SongDto);

    PlaylistResponseDto deleteTrack(String id, String trackId);

    List<SongDto> getTracks(String id);

    SongDto getTrack(String id, String trackId);

    SongDto updateTrack(String id, String trackId, SongDto songDto);

    List<PlaylistResponseDto> getPlaylistsForUsername(String username);
}
