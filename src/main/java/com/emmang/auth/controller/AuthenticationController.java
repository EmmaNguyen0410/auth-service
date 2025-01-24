package com.emmang.auth.controller;

import com.emmang.auth.dto.SignInRequest;
import com.emmang.auth.dto.SignInResponse;
import com.emmang.auth.dto.SignUpRequest;
import com.emmang.auth.entity.User;
import com.emmang.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(userService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signin(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(userService.signin(signInRequest));
    }
}
