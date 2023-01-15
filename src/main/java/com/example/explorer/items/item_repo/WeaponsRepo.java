package com.example.explorer.items.item_repo;

import com.example.explorer.items.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponsRepo extends JpaRepository<Weapon, Long> {
    Weapon findWeaponByName(String name);
}
