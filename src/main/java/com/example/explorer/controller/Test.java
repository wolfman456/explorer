package com.example.explorer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("hello");
    }
}
