package com.example.explorer.character.char_controller;

import com.example.explorer.character.character_serv.ClassService;
import com.example.explorer.character.model.user_char_dto.ClassDTO;
import com.example.explorer.exception.InformationExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/player-class")
public class ClassController {

    @Autowired
    private ClassService classService;

    private final Logger logger = LoggerFactory.getLogger(ClassController.class);

    @PostMapping("/create/")
    public ResponseEntity<?> createClass(@RequestBody ClassDTO classDTO){
        logger.info("calling createdCLass =====>");
        if (classDTO !=null) {
            try {
                String newClass = classService.createClass(classDTO);
                logger.info("ClassService createClass returned with object " + newClass);

            }catch (InformationExistException existException){
                logger.debug("CreateClass failed with message " + existException.getMessage());
                return ResponseEntity.internalServerError().build();
            }catch (Exception e){
                logger.debug("creatClass failed with message " + e.getMessage());
                return ResponseEntity.internalServerError().build();
            }
        }

        return ResponseEntity.internalServerError().build();
    }

}
