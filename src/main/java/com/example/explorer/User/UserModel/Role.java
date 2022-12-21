package com.example.explorer.User.UserModel;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Enum<RolesEnum> role;
}
