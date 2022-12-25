package com.example.explorer.Character.CharacterServ.UserCharSerImpl;

import com.example.explorer.Character.CharacterServ.RaceService;
import com.example.explorer.Character.char_repo.RaceRepo;
import com.example.explorer.Character.model.Race;
import com.example.explorer.Character.model.user_char_dto.RaceDTO;
import com.example.explorer.exception.InformationNotFoundException;
import com.example.explorer.user.User_model.ERole;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RaceRepo raceRepo;
    @Override
    public Race createNewRace(RaceDTO raceDTO){

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
        ObjectWriter writer = mapper.writer().withRootName("role");
        String json = writer.writeValueAsString(raceList);
        System.out.println(json);
        return json;
    }
}
