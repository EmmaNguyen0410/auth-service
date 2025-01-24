package com.emmang.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/guest")
@RestController
public class GuestController {
    @PostMapping("/hi")
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("hi guest user");
    }
}
