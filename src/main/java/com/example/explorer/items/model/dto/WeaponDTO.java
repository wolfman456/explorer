package com.example.explorer.items.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeaponDTO {
    private String weaponsId;
    private String name;
    private String Description;
    private String baseDamage;
    private Boolean magic;
    private String specialEffect;

}
