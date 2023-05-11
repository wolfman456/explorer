package com.example.explorer.character.character_serv;

import com.example.explorer.character.model.Race;
import com.example.explorer.character.model.user_char_dto.RaceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;


public interface RaceService {
    String createNewRace(RaceDTO raceDTO) throws Exception;
    List<Race> getAllRaces() throws JsonProcessingException;
    String updateRaceByName(String name, RaceDTO raceDTO) throws JsonProcessingException;
    String getRaceByName(String name) throws JsonProcessingException;

    String deleteRace(String name);
}
