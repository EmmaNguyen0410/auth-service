package com.emmang.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @PostMapping("/hi")
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("hi admin");
    }
}
