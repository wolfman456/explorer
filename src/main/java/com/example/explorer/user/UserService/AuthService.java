package com.example.explorer.user.UserService;


import com.example.explorer.user.User_model.dto.LoginDto;
import com.example.explorer.user.User_model.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
