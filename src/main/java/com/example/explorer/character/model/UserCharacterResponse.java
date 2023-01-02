package com.example.explorer.character.model;

import com.example.explorer.character.model.user_char_dto.PlayerClasses;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "user_char_response")
public class UserCharacterResponse {
    private Race race;
    private PlayerCharacter playerCharacter;
    private PlayerClasses classes;

}
