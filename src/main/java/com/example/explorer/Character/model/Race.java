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
    @NonNull
    @Column(unique = true, length = 80, updatable = false)
    private String raceName;
    @Column(nullable = false)
    private String raceDescription;
    @Column(nullable = false, length = 2)
    private Integer strMod;
    @Column(nullable = false, length = 2)
    private Integer wisMod;
    @Column(nullable = false, length = 2)
    private Integer intMod;
    @Column(nullable = false, length = 2)
    private Integer charMod;
    @Column(nullable = false, length = 2)
    private Integer conMod;

}
