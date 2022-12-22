package com.example.explorer.security.dto;

import com.example.explorer.user.User_model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String userName;
    private String email;
    private String password;
    private Set<String> role;
}
