package com.example.explorer.character.model.user_char_dto;

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
    String className;
    @Column
    String description;
    @Column
    Boolean spells;
}
