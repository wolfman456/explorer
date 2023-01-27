package com.example.explorer.character.char_controller;

import com.example.explorer.character.character_serv.RaceService;
import com.example.explorer.character.model.Race;
import com.example.explorer.character.model.user_char_dto.RaceDTO;
import com.example.explorer.utility.exception.InformationExistException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RaceControllerTest {

    @InjectMocks
    private RaceController controller;

    @Mock
    RaceService service;

    private  Race race = Race.builder().raceName("elf")
                .raceDescription("test")
                .charMod(1)
                .conMod(1)
                .strMod(1)
                .wisMod(1)
                .intMod(1).build();

    private RaceDTO raceDTO = RaceDTO.builder().raceName("elf")
                .raceDescription("test")
                .charMod(1)
                .conMod(1)
                .strMod(1)
                .wisMod(1)
                .intMod(1).build();

    private String EXPECTED = "{\"Races\":[{\"id\":null,\"raceName\":\"elf\",\"raceDescription\":\"test\",\"strMod\":1,\"wisMod\":1,\"intMod\":1,\"charMod\":1,\"conMod\":1}]}";

    @Test
    public void whenGetAllRaces_returnRaceString() throws Exception {

        List<Race> raceList = new ArrayList<>();
        raceList.add(race);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().withRootName("Races");
        String json = writer.writeValueAsString(raceList);

        when(service.getAllRaces()).thenReturn(json);

        ResponseEntity<?> response = controller.getAllRaces();

        System.out.println(response.getStatusCode());

        assertThat(response.getStatusCode().toString()).isEqualTo(HttpStatus.OK.toString());
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void whenRaceControllerGetAll_emptyList() throws JsonProcessingException {
        List<Race> raceList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().withRootName("Races");
        String json = writer.writeValueAsString(raceList);

        when(service.getAllRaces()).thenReturn(json);

        ResponseEntity<?> response = controller.getAllRaces();

        assertThat(response.getBody()).isEqualTo("{\"Races\":[]}");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    public void whenRaceControllerCreateRace_returnRaceString() throws Exception {
        when(service.createNewRace(any(RaceDTO.class))).thenReturn(race);

        ResponseEntity<?> response = controller.createNewRace(raceDTO);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenRaceControllerCreateRace_nameAlreadyExists_returnInformationExistException() throws Exception {
        when(service.createNewRace(any(RaceDTO.class))).thenThrow(InformationExistException.class);

        ResponseEntity<?> response = controller.createNewRace(raceDTO);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void whenRaceControllerCreateRace_nameAlreadyExists_returnInformationGenericException() throws Exception {
        when(service.createNewRace(any(RaceDTO.class))).thenThrow(Exception.class);

        ResponseEntity<?> response = controller.createNewRace(raceDTO);

        System.out.println(response.getStatusCode());
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void whenRaceControllerUpdateRace_returnUpdatedRace() throws JsonProcessingException {
        race.setRaceName("bob");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String json = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(race);

        System.out.println(json);

        when(service.updateRaceByName(anyString(), any(RaceDTO.class))).thenReturn(json);

        ResponseEntity<?> response = controller.updateRaceByName("elf", raceDTO);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEqualTo(EXPECTED);
    }

}
