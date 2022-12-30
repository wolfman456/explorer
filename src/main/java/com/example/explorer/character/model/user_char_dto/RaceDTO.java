package com.example.explorer.character.model.user_char_dto;

import com.example.explorer.character.model.Race;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RaceDTO{
    private String raceName;
    private String raceDescription;
    private Integer strMod;
    private Integer wisMod;
    private Integer intMod;
    private Integer charMod;
    private Integer conMod;
}
