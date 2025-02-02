package com.emmang.auth.service;

import com.emmang.auth.constant.ExceptionMessage;
import com.emmang.auth.dto.SignInRequest;
import com.emmang.auth.dto.SignInResponse;
import com.emmang.auth.dto.SignUpRequest;
import com.emmang.auth.entity.User;
import com.emmang.auth.entity.UserDetailsImpl;
import com.emmang.auth.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRespository;
    private final AuthenticationManager authenticationManager;

    public UserService(JwtService jwtService, BCryptPasswordEncoder passwordEncoder, UserRepository userRespository, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRespository = userRespository;
        this.authenticationManager = authenticationManager;
    }

    public User signup (SignUpRequest signUpRequest) {
        User user = new User();
        user.setFullName(signUpRequest.getFullName());
        user.setEmail(signUpRequest.getEmail());
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(signUpRequest.getRole());

        return userRespository.save(user);
    }

    public SignInResponse signin(SignInRequest signInRequest) {
        String username = signInRequest.getUsername();
        String password = signInRequest.getPassword();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        Optional<User> authenticatedUserOptional = userRespository.findByUsername(username);

        if (authenticatedUserOptional.isPresent()) {
            User authenticatedUser = authenticatedUserOptional.get();
            String jwtToken = jwtService.generateToken(authenticatedUser);

            SignInResponse signInResponse = new SignInResponse();

            signInResponse.setToken(jwtToken);
            signInResponse.setExpiresIn(jwtService.getJwtExpirationTime());

            return signInResponse;
        } else {
            throw new UsernameNotFoundException(ExceptionMessage.USER_NOT_FOUND);
        }
    }
}
