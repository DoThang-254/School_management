package com.example.school_management.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AccountValidation {
    @NotBlank(message = "username is required")
    @Size(min = 1, message = "username is invalid")
    private String username;

    @NotBlank(message="password is required")
    @Size(min = 8, message = "password is invalid")
    private String password;

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
}
