package com.example.explorer.Character.char_repo;

import com.example.explorer.Character.model.UserChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCharaterRepo extends JpaRepository<UserChar, Long> {
}
