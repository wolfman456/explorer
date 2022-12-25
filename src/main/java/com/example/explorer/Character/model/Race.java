package com.example.explorer.Character.model;


import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonRootName(value = "race")
@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String raceName;
    private String raceDescription;
    private Integer strMod;
    private Integer wisMod;
    private Integer intMod;
    private Integer charMod;
    private Integer conMod;

}
