package com.example.explorer.user.UserController;

import com.example.explorer.user.UserService.AuthService;
import com.example.explorer.security.JWTAuthResponse;
import com.example.explorer.user.User_model.dto.LoginDto;
import com.example.explorer.user.User_model.dto.RegisterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    @Autowired
    private AuthService authService;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    // Build Login REST API
    @GetMapping(value = "/login")
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
        logger.info("Calling login method");
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @GetMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        logger.info("calling Register Function");
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
