package com.example.explorer.character.race_repo_test;

import com.example.explorer.character.char_repo.RaceRepo;
import com.example.explorer.character.model.Race;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RaceRepoTest {

    @Autowired
    private RaceRepo raceRepo;

    private static Race race;

    @BeforeEach
    public void setup() {
        race = Race.builder().raceName("elf")
                .raceDescription("test")
                .charMod(1)
                .conMod(1)
                .strMod(1)
                .wisMod(1)
                .intMod(1).build();
    }

    @Test
    public void whenRaceObject_save_thenReturnSavedObject(){
        Race savedRace = raceRepo.save(race);

        assertThat(savedRace).isNotNull();
        assertThat(savedRace.getRaceName()).isEqualTo(race.getRaceName());
        assertThat(savedRace.getId()).isNotNull();

    }

    @Test
    public void whenRaceName_findByRaceId_thenReturnRaceObject(){
        Race savedRace = raceRepo.save(race);
        Race returnedRace = raceRepo.findByRaceName(savedRace.getRaceName());

        assertThat(returnedRace).isNotNull();
    }
}
