package com.example.explorer.Character.model.user_char_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RaceDTO {
    private String raceName;
    private String raceDescription;
    private Integer strMod;
    private Integer wisMod;
    private Integer intMod;
    private Integer charMod;
    private Integer conMod;
}
