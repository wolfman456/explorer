package com.example.explorer.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public String mapper(ExplorerResponse explorerResponse){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            return mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(explorerResponse);
        }catch (JsonProcessingException e){
            return e.getMessage();
        }
    }
}
