package com.example.explorer.character.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Long id;
    @NonNull
    @Column(unique = true, length = 80, updatable = false)
    private String raceName;
    @Column(nullable = false)
    private String raceDescription;
    @Column(nullable = false)
    private Integer strMod;
    @Column(nullable = false)
    private Integer wisMod;
    @Column(nullable = false)
    private Integer intMod;
    @Column(nullable = false)
    private Integer charMod;
    @Column(nullable = false)
    private Integer conMod;

}
