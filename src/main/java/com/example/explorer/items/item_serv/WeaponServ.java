package com.example.explorer.items.item_serv;

import com.example.explorer.items.model.dto.WeaponDTO;

public interface WeaponServ {
    String getAllWeapons();
    String getWeaponByName(String name);
    String createWeapon(WeaponDTO weaponDTO);
    String updateWeapon(WeaponDTO weaponDTO, String name);
    String deleteWeapon(String name);
}
