package com.example.explorer.Character.CharacterServ.UserCharSerImpl;

import com.example.explorer.Character.CharacterServ.RaceService;
import com.example.explorer.Character.char_repo.RaceRepo;
import com.example.explorer.Character.model.Race;
import com.example.explorer.Character.model.user_char_dto.RaceDTO;
import com.example.explorer.exception.InformationNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RaceRepo raceRepo;
    @Override
    public Race createNewRace(RaceDTO raceDTO) throws Exception{

            Race race = Race.builder().raceName(raceDTO.getRaceName()).raceDescription(raceDTO.getRaceDescription())
                    .charMod(raceDTO.getCharMod()).conMod(raceDTO.getConMod()).intMod(raceDTO.getIntMod())
                    .strMod(raceDTO.getStrMod())
                    .wisMod(raceDTO.getWisMod())
                    .build();
            return raceRepo.save(race);
    }

    @Override
    public String getAllRaces() throws JsonProcessingException {
        List<Race> raceList = raceRepo.findAll();

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().withRootName("Races");
        String json = writer.writeValueAsString(raceList);
        System.out.println(json);
        return json;
    }

    @Override
    public String updateRaceByName(String name, RaceDTO raceDTO) throws InformationNotFoundException, JsonProcessingException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);


        Race race = raceRepo.findByRaceName(name);
        if (race == null){
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "race with name " + name + " not found",
                    LocalDateTime.now());
        }
        if (!raceDTO.getRaceName().isEmpty()){
            race.setRaceName(raceDTO.getRaceName());
        }
        if (!raceDTO.getRaceDescription().isEmpty()){
            race.setRaceDescription(raceDTO.getRaceDescription());
        }
        if (raceDTO.getConMod() != null){
            race.setConMod(raceDTO.getConMod());
        }
        if (raceDTO.getStrMod() != null){
            race.setStrMod(raceDTO.getStrMod());
        }
        if (raceDTO.getIntMod() != null){
            race.setIntMod(raceDTO.getIntMod());
        }
        if (raceDTO.getCharMod() != null){
            race.setCharMod(raceDTO.getCharMod());
        }
        if (raceDTO.getWisMod() != null){
            race.setWisMod(raceDTO.getWisMod());
        }
        raceRepo.save(race);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(race);

        return jsonString;
    }

    @Override
    public String getRaceByName(String name) throws InformationNotFoundException, JsonProcessingException {
        Race race = raceRepo.findByRaceName(name);
        if (race == null){
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "No race found with name " + name, LocalDateTime.now());
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(race);
        return jsonString;
    }
}
