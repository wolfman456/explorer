package com.example.explorer.items.item_repo;

import com.example.explorer.items.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeaponsRepo extends JpaRepository<Weapon, Long> {
    Optional<Weapon> findWeaponByName(String name);
<<<<<<< HEAD
    Weapon deleteWeaponByName(String name);
=======
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
}
