package com.example.explorer.items.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonRootName(value = "weapon")
@Entity
@Table(name = "weapons")
public class Weapon {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weaponsId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String baseDamage;
    @Column
    private Boolean magic;
    @Column
    private String specialEffect;

}
