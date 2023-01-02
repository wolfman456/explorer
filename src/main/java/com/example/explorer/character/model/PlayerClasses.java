package com.example.explorer.character.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonRootName(value = "player_class")
@Entity
@Table(name = "player_class")
public class PlayerClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column
    private Long playerCLassId;
    @Column
    private String className;
    @Column
    private String description;
    @Column
    private Boolean spells;
    @Column
    @JsonIgnore
    private String priority1;
    @Column
    @JsonIgnore
    private String priority2;
    @Column
    @JsonIgnore
    private String priority3;
    @Column
    @JsonIgnore
    private String priority4;
    @Column
    @JsonIgnore
    private String priority5;

}
