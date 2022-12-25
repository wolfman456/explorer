package com.example.explorer.comandrunners;

import com.example.explorer.Character.char_repo.RaceRepo;
import com.example.explorer.Character.model.Race;
import com.example.explorer.user.User_model.ERole;
import com.example.explorer.user.User_model.Role;
import com.example.explorer.user.User_model.UserModel;
import com.example.explorer.user.user_repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleRunner implements CommandLineRunner {

    @Autowired
    RoleRepository repository;

    @Autowired
    RaceRepo raceRepo;
    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setName(ERole.ROLE_ADMIN);
        repository.save(role);
        Role role1 = new Role();
        role1.setName(ERole.ROLE_USER);
        repository.save(role1);
        Role role2 = new Role();
        role2.setName(ERole.ROLE_MODERATOR);
        repository.save(role2);
        Race race = Race.builder().raceName("elf")
                .raceDescription("elfy")
                .wisMod(1)
                .strMod(1)
                .intMod(1).conMod(1)
                .charMod(1).build();
        raceRepo.save(race);

    }
}
