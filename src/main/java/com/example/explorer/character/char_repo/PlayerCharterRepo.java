package com.example.explorer.character.char_repo;
import com.example.explorer.character.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCharterRepo extends JpaRepository<PlayerCharacter, Long> {
}
