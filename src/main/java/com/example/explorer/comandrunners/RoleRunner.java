package com.example.explorer.comandrunners;

import com.example.explorer.user.User_model.Role;
import com.example.explorer.user.user_repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleRunner implements CommandLineRunner {

    @Autowired
    RoleRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setName("ROLE_USER");
        repository.save(role);

    }
}
