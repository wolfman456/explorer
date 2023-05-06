package com.example.explorer.items.item_serv;

import com.example.explorer.items.model.Weapon;
import com.example.explorer.items.model.dto.WeaponDTO;

import java.util.List;

public interface WeaponServ {
    List<Weapon> getAllWeapons();
    String getWeaponByName(String name);
    String createWeapon(WeaponDTO weaponDTO);
    String updateWeapon(WeaponDTO weaponDTO, String name);
    String deleteWeapon(String name);
}
