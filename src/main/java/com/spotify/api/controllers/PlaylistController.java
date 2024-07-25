package com.spotify.api.controllers;

import com.spotify.api.dtos.SongDto;
import com.spotify.api.dtos.playlist.PlaylistRequestDto;
import com.spotify.api.dtos.playlist.PlaylistResponseDto;
import com.spotify.api.services.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/playlists")
public class PlaylistController {
    
    private final PlaylistService playlistService;
    
    @GetMapping
    public List<PlaylistResponseDto> getPlaylists() {
        return playlistService.getPlaylists();
    }

    @GetMapping("/user/{username}")
    public List<PlaylistResponseDto> getPlaylistsForUser(@PathVariable("username") String username) {
        return playlistService.getPlaylistsForUsername(username);
    }
    
    @GetMapping("/{name}")
    public List<PlaylistResponseDto> getPlaylist(@PathVariable("name") String name) {
        return playlistService.getPlaylist(name);
    }
    
    @PostMapping
    public PlaylistResponseDto postPlaylist(@RequestBody PlaylistRequestDto playlistDto) {
        return playlistService.createPlaylist(playlistDto);
    }
    
    @PutMapping("/{id}")
    public PlaylistResponseDto putPlaylist(@PathVariable String id, @RequestBody PlaylistRequestDto playlistDto) {
        return playlistService.updatePlaylist(id, playlistDto);
    }
    
    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylist(id);
    }
    
    @PostMapping("/{id}/tracks")
    public PlaylistResponseDto postTrack(@PathVariable String id, @RequestBody SongDto songDto) {
        return playlistService.addTrack(id, songDto);
    }
    
    @DeleteMapping("/{id}/tracks/{trackId}")
    public PlaylistResponseDto deleteTrack(@PathVariable String id, @PathVariable String trackId) {
        return playlistService.deleteTrack(id, trackId);
    }
    
    @GetMapping("/{id}/tracks")
    public List<SongDto> getTracks(@PathVariable String id) {
        return playlistService.getTracks(id);
    }
    
    @GetMapping("/{id}/tracks/{trackId}")
    public SongDto getTrack(@PathVariable String id, @PathVariable String trackId) {
        return playlistService.getTrack(id, trackId);
    }
    
    @PutMapping("/{id}/tracks/{trackId}")
    public SongDto putTrack(@PathVariable String id, @PathVariable String trackId, @RequestBody SongDto songDto) {
        return playlistService.updateTrack(id, trackId, songDto);
    }

}
