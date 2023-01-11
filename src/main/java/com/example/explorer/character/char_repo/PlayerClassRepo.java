package com.example.explorer.character.char_repo;

import com.example.explorer.character.model.PlayerClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerClassRepo extends JpaRepository<PlayerClasses, Long> {
    PlayerClasses findPlayerClassesByClassName(String name);
}
