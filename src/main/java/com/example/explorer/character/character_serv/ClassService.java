package com.example.explorer.character.character_serv;

import com.example.explorer.character.model.PlayerClasses;
import com.example.explorer.character.model.user_char_dto.ClassDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ClassService {
    String createClass(ClassDTO classDTO) throws JsonProcessingException;
    String getClassByName(String name) throws JsonProcessingException;
    List<PlayerClasses> getAllClasses();
    String updateCLass(String name, ClassDTO classDTO) throws JsonProcessingException;
    String deleteClass(String name);
}
