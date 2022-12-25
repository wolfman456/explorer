package com.example.explorer.Character.char_controller;

import com.example.explorer.Character.CharacterServ.RaceService;
import com.example.explorer.Character.model.Race;
import com.example.explorer.Character.model.user_char_dto.RaceDTO;
import com.example.explorer.exception.InformationExistException;
import com.example.explorer.exception.InformationNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
                String jsonString = mapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(race);
                return ResponseEntity.ok(jsonString);
            }

        }catch (InformationNotFoundException notFoundException){
            logger.debug(notFoundException.getMessage(), notFoundException.getCause());

        }catch (InformationExistException existException){
            logger.debug(existException.getMessage(), existException.getCause());

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
            List<Race> raceList = raceService.getAllRaces();
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(raceList);
            return ResponseEntity.ok(jsonString);
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseEntity.badRequest().body("failed to get races");
        }

    }
}
