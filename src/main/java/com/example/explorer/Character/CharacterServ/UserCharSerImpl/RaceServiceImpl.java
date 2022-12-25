package com.example.explorer.Character.CharacterServ.UserCharSerImpl;

import com.example.explorer.Character.CharacterServ.RaceService;
import com.example.explorer.Character.char_repo.RaceRepo;
import com.example.explorer.Character.model.Race;
import com.example.explorer.Character.model.user_char_dto.RaceDTO;
import com.example.explorer.exception.InformationNotFoundException;
import com.example.explorer.user.User_model.ERole;
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
    public Race createNewRace(RaceDTO raceDTO) throws Exception{

            Race race = Race.builder().raceName(raceDTO.getRaceName()).raceDescription(raceDTO.getRaceDescription())
                    .charMod(raceDTO.getCharMod()).conMod(raceDTO.getConMod()).intMod(raceDTO.getIntMod())
                    .strMod(raceDTO.getStrMod())
                    .wisMod(raceDTO.getWisMod())
                    .build();
            return raceRepo.save(race);
    }

    @Override
    public List<Race> getAllRaces() {
        return raceRepo.findAll();
    }
}
