package com.example.explorer.Character.CharacterServ;

import com.example.explorer.Character.model.Race;
import com.example.explorer.Character.model.user_char_dto.RaceDTO;

import java.util.List;


public interface RaceService {
    Race createNewRace(RaceDTO raceDTO) throws Exception;
    List<Race> getAllRaces();
}
