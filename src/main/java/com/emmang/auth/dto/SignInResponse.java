package com.emmang.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// TODO fix lombok annotation
public class SignInResponse {
    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    private long expiresIn;
}
