package com.example.explorer.utility;

import com.example.explorer.character.model.Race;
import com.example.explorer.items.model.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.env.RandomValuePropertySource;

import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomMapper {
    private Race race;
    private Item item;


    public String mapper(CustomMapper customMapper){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(customMapper);
            return jsonString;
        }catch (JsonProcessingException e){
            return e.getMessage();
        }
    }
}
