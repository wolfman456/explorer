package com.example.explorer.character.character_serv.user_char_ser_impl;

import com.example.explorer.character.char_repo.RaceRepo;
import com.example.explorer.character.character_serv.user_char_serv_impl.RaceServiceImpl;
import com.example.explorer.character.model.Race;
import com.example.explorer.character.model.user_char_dto.RaceDTO;
import com.example.explorer.utility.exception.InformationExistException;
import com.example.explorer.utility.exception.InformationNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RaceServiceTest {

    @Mock
    private RaceRepo raceRepo;

    @InjectMocks
    RaceServiceImpl raceService;

    private Race race;
    private RaceDTO raceDTO;

    @BeforeEach
    public void setup(){
        race = Race.builder().raceName("elf")
                .raceDescription("test")
                .charMod(1)
                .conMod(1)
                .strMod(1)
                .wisMod(1)
                .intMod(1).build();

        raceDTO = RaceDTO.builder().raceName("elf")
                .raceDescription("test")
                .charMod(1)
                .conMod(1)
                .strMod(1)
                .wisMod(1)
                .intMod(1).build();
    }


    @Test
    public void givenRaceExitingName_whenCreateRace_thenThrowException(){
        when(raceRepo.findByRaceName(race.getRaceName())).thenReturn(race);
        org.junit.jupiter.api.Assertions.assertThrows(InformationExistException.class, () ->
        {
            raceService.createNewRace(raceDTO);
        });

        verify(raceRepo, never()).save(any(Race.class));
    }

    @Test
    public void givenRaceObject_WhenUpdateRaceByName_returnUpdatedRaceObject() throws JsonProcessingException {

        when(raceRepo.findByRaceName(anyString())).thenReturn(race);
        raceDTO.setRaceName("elf dude");

        String updatedRace = raceService.updateRaceByName(race.getRaceName(), raceDTO);

        assertThat(updatedRace).isNotNull();
        assertThat(updatedRace).isEqualTo("""
                {
                  "race" : {
                    "raceName" : "elf dude",
                    "raceDescription" : "test",
                    "strMod" : 1,
                    "wisMod" : 1,
                    "intMod" : 1,
                    "charMod" : 1,
                    "conMod" : 1
                  }
                }""");
    }

    @Test
    public void givenRaceName_whenUpdateRaceByName_returnNoInformationFoundException(){
        when(raceRepo.findByRaceName(anyString())).thenReturn(null);

        org.junit.jupiter.api.Assertions.assertThrows(InformationNotFoundException.class, () ->
        {
            raceService.updateRaceByName("bob", raceDTO);
        });

        verify(raceRepo, never()).save(any(Race.class));
    }

    @Test
    public void givenRaceName_whenDeleteRaceByName_returnNoInformationFoundException(){
        when(raceRepo.findByRaceName(anyString())).thenReturn(null);

        org.junit.jupiter.api.Assertions.assertThrows(InformationNotFoundException.class, () ->
        {
            raceService.deleteRace("bob");
        });

        verify(raceRepo, never()).delete(any(Race.class));
    }

    @Test
    public void givenRaceName_whenDeleteRaceByName_returnSuccessMessage(){

        when(raceRepo.findByRaceName(anyString())).thenReturn(race);
        doNothing().when(raceRepo).delete(any(Race.class));

        String message = raceService.deleteRace(race.getRaceName());

        assertThat(message).isNotNull();
        assertThat(message).isEqualTo("race " +race.getRaceName()+ " successfully deleted");
        verify(raceRepo, times(1)).delete(race);
    }

}
