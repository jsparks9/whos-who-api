package com.spotify.api.mappers;

import com.spotify.api.dtos.SettingsDto;
import com.spotify.api.entitites.Settings;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SettingsMapper {
    Settings dtoToEntity(SettingsDto settingsDto);
    SettingsDto entityToDto(Settings settings);
}
