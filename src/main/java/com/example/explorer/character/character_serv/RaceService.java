package com.example.explorer.character.character_serv;

import com.example.explorer.character.model.user_char_dto.RaceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;


public interface RaceService {
    String createNewRace(RaceDTO raceDTO) throws Exception;
<<<<<<< HEAD
    List<Race> getAllRaces() throws JsonProcessingException;
=======
    List<String> getAllRaces() throws JsonProcessingException;
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
    String updateRaceByName(String name, RaceDTO raceDTO) throws JsonProcessingException;
    String getRaceByName(String name) throws JsonProcessingException;

    String deleteRace(String name);
}
