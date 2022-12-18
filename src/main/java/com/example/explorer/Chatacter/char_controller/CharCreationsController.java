package com.example.explorer.Chatacter.char_controller;

import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharCreationsController {
    private Logger logger;
    @GetMapping("/api/welcome/")
    public ResponseEntity<String> getWelcome(){
        logger.info("calling test api welcome");
        return ResponseEntity.ok("hello");
    }
}
