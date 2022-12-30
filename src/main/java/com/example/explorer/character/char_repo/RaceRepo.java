package com.example.explorer.character.char_repo;

import com.example.explorer.character.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepo extends JpaRepository<Race, Long> {
    Race findByRaceName (String name);

}
