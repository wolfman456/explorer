package com.example.explorer.character.char_controller;

import com.example.explorer.character.character_serv.RaceService;
import com.example.explorer.character.model.Race;
import com.example.explorer.character.model.user_char_dto.RaceDTO;
import com.example.explorer.utility.exception.InformationExistException;
import com.example.explorer.utility.exception.InformationNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/admin")
public class RaceController {

    @Autowired
    private RaceService raceService;



    private final Logger logger = LoggerFactory.getLogger(RaceController.class);

    @PostMapping(value = "/create_new_race")
    public ResponseEntity<?> createNewRace(@RequestBody RaceDTO raceDTO){
        logger.info("calling createNewRace");
        try {
            if (raceDTO != null){
                String race = raceService.createNewRace(raceDTO);

                return ResponseEntity.ok(race);
            }

        } catch (InformationExistException info){
            logger.debug("createNewRace failed with error message : " + info.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e){
            logger.debug(e.getMessage(), e.getCause());
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.badRequest().body("No information found");
    }
    @GetMapping(value = "getall")
    public ResponseEntity<?> getAllRaces(){
        logger.info("Calling getAllRaces methods =======>");
        try {
            List<Race> raceList = raceService.getAllRaces();

            return ResponseEntity.ok(raceList);

        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseEntity.badRequest().body("failed to get races");
        }
    }

    @PutMapping(value = "/update_race_by_name/{name}")
    public ResponseEntity<?> updateRaceByName(@PathVariable(value = "name") String name,
                                           @RequestBody RaceDTO raceDTO){
        if (!name.isEmpty() && raceDTO != null){
            try {
                String updateRace = raceService.updateRaceByName(name, raceDTO);
                return ResponseEntity.ok(updateRace);
            }catch (InformationNotFoundException | JsonProcessingException notFoundException){
                logger.debug("Exception encountered well performing updateRaceByName " +
                        "with message " + notFoundException.getMessage());
                return ResponseEntity.badRequest().build();
            }catch (Exception e){
                return ResponseEntity.internalServerError().build();
            }

        }
        return ResponseEntity.badRequest().body("Race name or Update information missing");
    }

    @GetMapping(value = "get_race_by_name/{name}")
    public ResponseEntity<?> getRaceByName(@PathVariable(value = "name") String name){
        if (!name.isEmpty()){
            try {
                String race = raceService.getRaceByName(name);
                return ResponseEntity.ok(race);
            }catch (InformationNotFoundException notFoundException){
                logger.debug("Exception encountered well performing getRaceByName " +
                        "with message " + notFoundException.getMessage());
                return ResponseEntity.noContent().build();
            } catch (JsonProcessingException e) {
                logger.debug("exception occurred during serialization with message " +e.getMessage());
                return ResponseEntity.internalServerError().build();
            }

        }
        return ResponseEntity.badRequest().body("no name found in request");
    }

    @DeleteMapping(value = "delete_race_by_name/{name}")
    public ResponseEntity<?> deleteRaceByName(@PathVariable(value = "name") String name){
        try {
            if (name != null){
                return ResponseEntity.ok(raceService.deleteRace(name));
            }
        }catch (InformationNotFoundException notFoundException){
            logger.debug("deleteRace failed with message : " + notFoundException.getMessage());
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            logger.debug("deleteRace failed with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
