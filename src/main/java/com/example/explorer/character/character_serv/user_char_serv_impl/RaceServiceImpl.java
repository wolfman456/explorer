package com.example.explorer.character.character_serv.user_char_serv_impl;

import com.example.explorer.character.character_serv.RaceService;
import com.example.explorer.character.char_repo.RaceRepo;
import com.example.explorer.character.model.Race;
import com.example.explorer.character.model.user_char_dto.RaceDTO;
import com.example.explorer.utility.CustomerMapper;
import com.example.explorer.utility.ExplorerResponse;
import com.example.explorer.utility.exception.InformationExistException;
import com.example.explorer.utility.exception.InformationNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {
    private final ExplorerResponse explorerResponse = new ExplorerResponse();

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RaceRepo raceRepo;
    @Override
    public String createNewRace(RaceDTO raceDTO) throws InformationExistException{
            if (raceRepo.findByRaceName(raceDTO.getRaceName()) == null) {
                Race race = Race.builder().raceName(raceDTO.getRaceName()).raceDescription(raceDTO.getRaceDescription())
                        .charMod(raceDTO.getCharMod()).conMod(raceDTO.getConMod()).intMod(raceDTO.getIntMod())
                        .strMod(raceDTO.getStrMod())
                        .wisMod(raceDTO.getWisMod())
                        .build();
                raceRepo.save(race);
<<<<<<< HEAD
                ExplorerResponse explorerResponse = new ExplorerResponse();
=======
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
                explorerResponse.setRace(race);
                return customerMapper.mapper(explorerResponse);

            }else {
                throw new InformationExistException(HttpStatus.CONFLICT, "information already exits", LocalDateTime.now());
            }
    }

    @Override
<<<<<<< HEAD
    public List<Race> getAllRaces() {
        List<Race> raceList = raceRepo.findAll();

        return raceList;
=======
    public List<String> getAllRaces() throws JsonProcessingException {
        List<Race> raceList = raceRepo.findAll();


        List<String> formattedRaceList = new ArrayList<>();
        for (Race race: raceList) {
            explorerResponse.setRace(race);
            formattedRaceList.add(customerMapper.mapper(explorerResponse));

        }

        return formattedRaceList;
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
    }

    @Override
    public String updateRaceByName(String name, RaceDTO raceDTO) throws InformationNotFoundException, JsonProcessingException {

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

        return mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(race);
    }

    @Override
    public String getRaceByName(String name) throws InformationNotFoundException, JsonProcessingException {
        Race race = raceRepo.findByRaceName(name);
        if (race == null){
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "No race found with name " + name, LocalDateTime.now());
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(race);
    }

    @Override
    public String deleteRace(String name) throws InformationNotFoundException{
        Race race = raceRepo.findByRaceName(name);
        if (race != null){
            raceRepo.delete(race);
            return "race " +name+ " successfully deleted";
        }else{
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "no race with name " + name + " found", LocalDateTime.now());
        }
    }


}
