package com.example.explorer.character.char_controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.explorer.character.character_serv.ClassService;
import com.example.explorer.character.model.PlayerClasses;
import com.example.explorer.character.model.user_char_dto.ClassDTO;
import com.example.explorer.utility.exception.InformationExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class ClassControllerTest {

    private ClassController classController;

    @Mock
    private ClassService classService;

    @Mock
    private Logger logger;

    @BeforeEach
    public void setUp() {
        classController = new ClassController();
        classController.classService = classService;
        classController.logger = logger;
    }

    @Test
    public void testCreateClass() throws Exception {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setClassName("Warrior");
        when(classService.createClass(any(ClassDTO.class))).thenReturn("Warrior");

        ResponseEntity<?> response = classController.createClass(classDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Warrior", response.getBody());
    }

    @Test
    public void testCreateClassWithInformationExistException() throws Exception {

        ClassDTO classDTO = new ClassDTO();
        classDTO.setClassName("Warrior");
        when(classService.createClass(any(ClassDTO.class))).thenThrow(new InformationExistException(HttpStatus.BAD_REQUEST, "class with name " + classDTO.getClassName() + " already exists",
                LocalDateTime.now()));

        ResponseEntity<?> response = classController.createClass(classDTO);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testGetAllClasses() throws Exception {

        List<PlayerClasses> playerClasses = new ArrayList<>();
        PlayerClasses playerClasses1 = new PlayerClasses();
        playerClasses1.setClassName("Warrior");
        PlayerClasses playerClasses2 = new PlayerClasses();
        playerClasses2.setClassName("Mage");
        playerClasses.add(playerClasses1);
        playerClasses.add(playerClasses2);
        when(classService.getAllClasses()).thenReturn(playerClasses);

        ResponseEntity<?> response = classController.getAllClasses();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(playerClasses, response.getBody());
    }

}
