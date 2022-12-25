package com.example.explorer.Character.char_controller;

import com.example.explorer.Character.CharacterServ.RaceService;
import com.example.explorer.Character.model.Race;
import com.example.explorer.Character.model.user_char_dto.RaceDTO;
import com.example.explorer.exception.InformationNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/admin")
public class RaceController {

    @Autowired
    private RaceService raceService;

    private Logger logger = LoggerFactory.getLogger(RaceController.class);

    @PostMapping(value = "/create_new_race")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createNewRace(@RequestBody RaceDTO raceDTO){
        logger.info("calling createNewRace");
        try {
            if (raceDTO != null){
                Race race = raceService.createNewRace(raceDTO);
                ObjectMapper mapper = new ObjectMapper();
                String jsonString = mapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(race);
                return ResponseEntity.ok(jsonString);
            }

        }catch (Exception e){
            logger.debug(e.getMessage(), e.getCause());

        }
            return ResponseEntity.badRequest().body("No information found");
    }
    @GetMapping(value = "getall")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllRaces(){
        logger.info("Calling getAllRaces methods =======>");
        try {
            String raceList = raceService.getAllRaces();

            return ResponseEntity.ok(raceList);

        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseEntity.badRequest().body("failed to get races");
        }
    }

    @PutMapping(value = "/update_race_by_name/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getRaceByName(@PathVariable(value = "name") String name,
                                           @RequestBody RaceDTO raceDTO){
        if (!name.isEmpty() && raceDTO != null){
            try {
                String updateRace = raceService.updateRaceByName(name, raceDTO);
                return ResponseEntity.ok(updateRace);
            }catch (InformationNotFoundException | JsonProcessingException notFoundException){
                logger.debug("Exception encountered well performing updateRaceByName " +
                        "with message " + notFoundException.getMessage());
            }

        }
        return ResponseEntity.badRequest().body("Race name or Update information missing");
    }

    @GetMapping(value = "get_race_by_name/{name}")
    @PreAuthorize("hasRole('ADMIN')")
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
                throw new RuntimeException(e);
            }

        }
        return ResponseEntity.badRequest().body("no name found in request");
    }


}
