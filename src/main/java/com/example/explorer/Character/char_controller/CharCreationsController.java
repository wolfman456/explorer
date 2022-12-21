package com.example.explorer.Character.char_controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharCreationsController {
    private static final Logger logger = LoggerFactory.getLogger(CharCreationsController.class);

    @GetMapping("/welcome/")
    public ResponseEntity<String> getWelcome(){
        logger.info("calling test api welcome");
        return ResponseEntity.ok("hello");
    }

//    @PostMapping("/createUserChar/")
//    public ResponseEntity<?> creatUserChar(@RequestBody )
}
