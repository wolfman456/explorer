package com.example.explorer.character.character_serv.user_char_serv_impl;

import com.example.explorer.character.char_repo.PlayerClassRepo;
import com.example.explorer.character.character_serv.ClassService;
import com.example.explorer.character.model.PlayerClasses;
import com.example.explorer.character.model.user_char_dto.ClassDTO;
import com.example.explorer.utility.exception.InformationExistException;
import com.example.explorer.utility.exception.InformationNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private PlayerClassRepo playerClassRepo;
    @Override
    public String createClass(ClassDTO classDTO) throws JsonProcessingException, InformationExistException {
        if (playerClassRepo.findPlayerClassesByClassName(classDTO.getClassName()) != null){
            throw new InformationExistException(HttpStatus.BAD_REQUEST, "class with name " + classDTO.getClassName() + " already exists",
                    LocalDateTime.now());
        }
        PlayerClasses playerClasses = PlayerClasses.builder().className(classDTO.getClassName())
                .spells(classDTO.getSpells())
                .description(classDTO.getDescription())
                .priority1(classDTO.getPriority1())
                .priority2(classDTO.getPriority2())
                .priority3(classDTO.getPriority3())
                .priority4(classDTO.getPriority4())
                .priority5(classDTO.getPriority5()).build();
        playerClassRepo.save(playerClasses);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(playerClasses);

    }

    @Override
    public String getClassByName(String name) throws JsonProcessingException, InformationNotFoundException {
        PlayerClasses playerClasses = playerClassRepo.findPlayerClassesByClassName(name);
        if (playerClasses == null){
            throw new InformationNotFoundException(HttpStatus.BAD_REQUEST, "No class with name " + name + " found", LocalDateTime.now());
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(playerClasses);
    }

    @Override
    public List<PlayerClasses> getAllClasses() {
        return playerClassRepo.findAll();
    }

    @Override
    public String updateCLass(String name, ClassDTO classDTO) throws InformationNotFoundException, JsonProcessingException {
        PlayerClasses playerClasses = playerClassRepo.findPlayerClassesByClassName(name);
        if (playerClasses == null){
            throw new InformationNotFoundException(HttpStatus.BAD_REQUEST, "no class with name " + name + " found", LocalDateTime.now());
        }
        if (classDTO.getClassName() != null){
            playerClasses.setSpells(classDTO.getSpells());
        }
        if (classDTO.getSpells() != null){
            playerClasses.setClassName(classDTO.getClassName());
        }if (classDTO.getDescription() != null){
            playerClasses.setDescription(classDTO.getDescription());
        }
        playerClassRepo.save(playerClasses);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(playerClasses);
    }

    @Override
    public String deleteClass(String name) throws InformationNotFoundException{
        PlayerClasses playerClasses = playerClassRepo.findPlayerClassesByClassName(name);

        if (playerClasses == null){
            throw new InformationNotFoundException(HttpStatus.BAD_REQUEST, "no class with name " + name + " found", LocalDateTime.now());
        }
        playerClassRepo.delete(playerClasses);
        return "class " + name + " deleted";
    }
}
