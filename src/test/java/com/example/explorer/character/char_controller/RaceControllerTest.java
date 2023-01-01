package com.example.explorer.character.char_controller;

import com.example.explorer.character.character_serv.RaceService;
import com.example.explorer.character.model.Race;
import com.example.explorer.character.model.user_char_dto.RaceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

}
