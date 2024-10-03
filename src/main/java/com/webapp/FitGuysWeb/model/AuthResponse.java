package com.webapp.FitGuysWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class AuthResponse {
    private String token;
    private User user; // or a simplified DTO of User if needed

    public AuthResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

}
