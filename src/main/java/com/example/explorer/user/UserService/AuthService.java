package com.example.explorer.user.UserService;


import com.example.explorer.security.dto.LoginDto;
import com.example.explorer.security.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
