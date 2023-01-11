package com.example.explorer.character.model.user_char_dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassDTO {

    private String className;
    private String description;
    private Boolean spells;
    private String priority1;
    private String priority2;
    private String priority3;
    private String priority4;

    private String priority5;
}
