package com.example.explorer.user.User_model;

import com.example.explorer.character.model.PlayerCharacter;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "user")
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(unique = true, nullable = false, length = 60)
    private String userName;
    @Column(unique = true, nullable = false)
    private String email;
    private String Password;
    private Boolean isActive;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;
    @OneToMany
    @JoinTable(name = "user_character",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "character_id", referencedColumnName = "charName"))
    List<PlayerCharacter> playerCharacters;
}
