//package com.example.explorer.comandrunners;
//
//import com.example.explorer.character.char_repo.PlayerCharterRepo;
//import com.example.explorer.character.char_repo.PlayerClassRepo;
//import com.example.explorer.character.char_repo.RaceRepo;
//import com.example.explorer.character.model.PlayerCharacter;
//import com.example.explorer.character.model.PlayerClasses;
//import com.example.explorer.character.model.Race;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TestRunner implements CommandLineRunner {
//
//    @Autowired
//    RaceRepo raceRepo;
//
//    @Autowired
//    PlayerCharterRepo charterRepo;
//
//    @Autowired
//    private PlayerClassRepo playerClassRepo;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        // create races
//        Race race = Race.builder().raceName("elf")
//                .raceDescription("elfy")
//                .wisMod(1)
//                .strMod(1)
//                .intMod(1).conMod(1)
//                .charMod(1).build();
//        raceRepo.save(race);
//
//        PlayerClasses playerClasses = PlayerClasses.builder().className("Warrior")
//                .description("hits thing with club")
//                .spells(false).priority1("strength").build();
//        PlayerClasses savedClass = playerClassRepo.save(playerClasses);
//
//        PlayerCharacter userChar = new PlayerCharacter();
//        userChar.setCharName("lone");
//        userChar.setUserName("bob");
//        userChar.setCon(10);
//        userChar.setWis(10);
//        userChar.setStr(10);
//        userChar.setCharisma(10);
//        userChar.setRace(race);
//        userChar.setBaseAct(1);
//        userChar.setBaseSpellPoints(0);
//        userChar.setHitPoints(10);
//        userChar.setPlayerClasses(savedClass);
//
//        PlayerCharacter user = charterRepo.save(userChar);
//
//        ObjectMapper mapper1 = new ObjectMapper();
//        mapper1.enable(SerializationFeature.WRAP_ROOT_VALUE);
//        String jsonString = mapper1
//                .writerWithDefaultPrettyPrinter()
//                .writeValueAsString(user);
//        System.out.println(jsonString);
//
//
//    }
//
//
//}
