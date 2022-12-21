package com.example.explorer.User.UserModel;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long UserId;
    String name;
    String userName;
    String email;
    String Password;

    /*
    to be added later once security package added, one to many.
     */
//    String Role;
}
