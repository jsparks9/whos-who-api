package com.spotify.api.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class SettingsDto {

    @Pattern(regexp = "^(Easy|Medium|Hard)$", message = "Difficulty must be 'Easy', 'Medium', or 'Hard'.")
    private String difficulty;

    @Min(value = 0, message = "Time limit must be at least zero.")
    private int timeLimit;

    @Pattern(regexp = "^(Multiple|Free)$", message = "ResponseType must 'Multiple' or 'Free'.")
    private String responseType;

    @NotNull
    private List<String> genre;

    @NotNull
    private Boolean hints;
}
