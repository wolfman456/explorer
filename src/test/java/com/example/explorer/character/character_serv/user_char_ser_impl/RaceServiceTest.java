package com.example.explorer.character.character_serv.user_char_ser_impl;

import com.example.explorer.character.char_repo.RaceRepo;
import com.example.explorer.character.character_serv.user_char_serv_impl.RaceServiceImpl;
import com.example.explorer.character.model.Race;
import com.example.explorer.character.model.user_char_dto.RaceDTO;
import com.example.explorer.exception.InformationExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
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
    public void givenRaceObject_whenCreateRace_thenReturnRaceObject(){
        when(raceRepo.findByRaceName(raceDTO.getRaceName()))
                .thenReturn(null);

        when(raceRepo.save(any(Race.class))).thenReturn(race);

        Race raceReturn = raceService.createNewRace(raceDTO);

        assertThat(raceReturn).isNotNull();
        assertThat(raceReturn.getRaceName()).isEqualTo(raceDTO.getRaceName());
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

}
