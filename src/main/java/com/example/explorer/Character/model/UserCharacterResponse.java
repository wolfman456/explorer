package com.example.explorer.Character.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user_char_response")
public class UserCharacterResponse {
    private Race race;
    private UserChar userChar;

    public UserCharacterResponse(Race race, UserChar userChar) {
        this.race = race;
        this.userChar = userChar;
    }

    public UserCharacterResponse() {
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public UserChar getUserChar() {
        return userChar;
    }

    public void setUserChar(UserChar userChar) {
        this.userChar = userChar;
    }
}
