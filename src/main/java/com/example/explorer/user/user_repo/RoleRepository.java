package com.example.explorer.user.user_repo;


import com.example.explorer.user.User_model.ERole;
import com.example.explorer.user.User_model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Enum name);
}
