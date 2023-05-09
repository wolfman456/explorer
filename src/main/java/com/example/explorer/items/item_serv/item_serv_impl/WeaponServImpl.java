package com.example.explorer.items.item_serv.item_serv_impl;

import com.example.explorer.items.item_repo.WeaponsRepo;
import com.example.explorer.items.item_serv.WeaponServ;
import com.example.explorer.items.model.Weapon;
import com.example.explorer.items.model.dto.WeaponDTO;
import com.example.explorer.utility.CustomerMapper;
import com.example.explorer.utility.ExplorerResponse;
import com.example.explorer.utility.exception.InformationExistException;
import com.example.explorer.utility.exception.InformationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WeaponServImpl implements WeaponServ {

    @Autowired
    WeaponsRepo weaponsRepo;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Weapon> getAllWeapons() {
        return weaponsRepo.findAll();
    }

    @Override
    public String getWeaponByName(String name) throws InformationNotFoundException{
        Optional<Weapon> weapon = weaponsRepo.findWeaponByName(name);
        if (weapon.isPresent()){
            ExplorerResponse explorerResponse = new ExplorerResponse();
            explorerResponse.setWeapon(weapon.get());
            return customerMapper.mapper(explorerResponse);
        }else {
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "no weapon with name " + name + " found", LocalDateTime.now());
        }
    }

    @Override
    public String createWeapon(WeaponDTO weaponDTO) throws InformationNotFoundException{

        if (!weaponsRepo.findWeaponByName(weaponDTO.getName()).isEmpty()){
            throw new InformationExistException(HttpStatus.BAD_REQUEST, "A weapon with name " + weaponDTO.getName() + " already exists", LocalDateTime.now());
        }else {
            Weapon weapon = Weapon.builder().baseDamage(weaponDTO.getBaseDamage())
                    .description(weaponDTO.getDescription())
                    .magic(weaponDTO.getMagic())
                    .name(weaponDTO.getName())
                    .specialEffect(weaponDTO.getSpecialEffect())
                    .build();
            weaponsRepo.save(weapon);
            ExplorerResponse explorerResponse1 = new ExplorerResponse();
            explorerResponse1.setWeapon(weapon);
            return customerMapper.mapper(explorerResponse1);
        }
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
