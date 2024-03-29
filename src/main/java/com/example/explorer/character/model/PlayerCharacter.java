package com.example.explorer.character.model;

import com.example.explorer.items.model.Inventory;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Column(nullable = false, updatable = false)
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
    private Integer hitPoints;
    @Column
    private Integer baseAct;
    @Column
    private Integer baseSpellPoints;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private PlayerClasses playerClasses;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Inventory> inventory;

}
