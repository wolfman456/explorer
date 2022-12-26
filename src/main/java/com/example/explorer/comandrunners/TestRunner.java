package com.example.explorer.comandrunners;

import com.example.explorer.Character.char_repo.RaceRepo;
import com.example.explorer.Character.model.Race;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    RaceRepo raceRepo;


    @Override
    public void run(String... args) throws Exception {

        // create races
        Race race = Race.builder().raceName("elf")
                .raceDescription("elfy")
                .wisMod(1)
                .strMod(1)
                .intMod(1).conMod(1)
                .charMod(1).build();
        raceRepo.save(race);
        Race race2 = Race.builder().raceName("high elf")
                .raceDescription("elfy")
                .wisMod(10)
                .strMod(1)
                .intMod(1).conMod(1)
                .charMod(1).build();
        raceRepo.save(race2);
        //json serial
        Thread.sleep(5000);
        List<Race> raceList = raceRepo.findAll();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().withRootName("races");
        String json = writer.writeValueAsString(raceList);
        System.out.println(json);

    }
}
