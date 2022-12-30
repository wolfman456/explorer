package com.example.explorer.comandrunners;

import com.example.explorer.character.char_repo.PlayerCharterRepo;
import com.example.explorer.character.char_repo.RaceRepo;
import com.example.explorer.character.model.Race;
import com.example.explorer.character.model.UserChar;
import com.example.explorer.user.user_repo.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    RaceRepo raceRepo;

    @Autowired
    PlayerCharterRepo charterRepo;
    @Autowired
    private UserRepository userRepository;


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
        UserChar userChar = new UserChar();
        userChar.setCharName("lone");
        userChar.setUserId(1l);
        userChar.setCon(10);
        userChar.setWis(10);
        userChar.setStr(10);
        userChar.setCharisma(10);
        userChar.setRace("elf");
        userChar.setBaseAct(1);
        userChar.setBaseSpellPoints(0);
        userChar.setHitPoints(10);


        charterRepo.save(userChar);

        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = mapper1
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(userChar);
        System.out.println(jsonString);

    }
}
