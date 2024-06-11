package com.exam.battleships.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDto {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(min = 3)
    private String password;

    public @NotBlank @Size(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank @Size(min = 3, max = 20) String username) {
        this.username = username;
    }

    public @NotBlank @Size(min = 3) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 3) String password) {
        this.password = password;
    }
}
