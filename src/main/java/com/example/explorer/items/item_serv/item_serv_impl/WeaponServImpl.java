package com.example.explorer.items.item_serv.item_serv_impl;

import com.example.explorer.items.item_repo.WeaponsRepo;
import com.example.explorer.items.item_serv.WeaponServ;
import com.example.explorer.items.model.dto.WeaponDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponServImpl implements WeaponServ {

    @Autowired
    WeaponsRepo weaponsRepo;

    @Override
    public String getAllWeapons() {
        return null;
    }

    @Override
    public String getWeaponByName(String name) {
        return null;
    }

    @Override
    public String createWeapon(WeaponDTO weaponDTO) {
        return null;
    }

    @Override
    public String updateWeapon(WeaponDTO weaponDTO, String name) {
        return null;
    }

    @Override
    public String deleteWeapon(String name) {
        return null;
    }
}
