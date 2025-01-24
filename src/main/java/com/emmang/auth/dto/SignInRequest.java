package com.emmang.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
// TODO fix lombok annotation
public class SignInRequest {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;

    private String password;


}
