package com.example.explorer.character.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonRootName(value = "player_charter")
@Entity
@Table(name = "player_charter")
public class PlayerCharacter{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long charId;
    @Column(nullable = false)
    private String userName;
    @Column
    private String charName;
    @Column
    private Integer wis;
    @Column
    private Integer str;
    @Column
    private Integer charisma;
    @Column
    private Integer con;
    @Column Integer intelligent;
    @Column
    private String race;
    @Column
    private Integer hitPoints;
    @Column
    private Integer baseAct;
    @Column
    private Integer baseSpellPoints;

}
