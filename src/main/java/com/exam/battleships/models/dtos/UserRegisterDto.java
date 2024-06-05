package com.exam.battleships.models.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {

    @Size(min = 3, max = 10)
    @NotBlank
    private String username;
    @Size(min = 5, max = 20)
    @NotBlank
    private String fullName;
    @Email
    private String email;
    @Size(min = 3)
    private String password;
    @Size(min = 3)
    private String confirmPassword;

    public @Size(min = 3, max = 10) String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 3, max = 10) String username) {
        this.username = username;
    }

    public @Size(min = 5, max = 20) String getFullName() {
        return fullName;
    }

    public void setFullName(@Size(min = 5, max = 20) String fullName) {
        this.fullName = fullName;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Size(min = 3) String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 3) String password) {
        this.password = password;
    }

    public @Size(min = 3) String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@Size(min = 3) String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UserRegisterDto{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
