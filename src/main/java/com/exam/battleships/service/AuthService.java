package com.exam.battleships.service;

import com.exam.battleships.models.dtos.LoginDto;
import com.exam.battleships.models.dtos.UserRegisterDto;
import com.exam.battleships.models.entities.UserEntity;
import com.exam.battleships.repositories.UserRepository;
import com.exam.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public AuthService(UserRepository userRepository , LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public boolean register(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            return false;
        }
        Optional<UserEntity> byUsername = userRepository.findByUsername(userRegisterDto.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }
        Optional<UserEntity> byEmail = userRepository.findByEmail(userRegisterDto.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }


        UserEntity user = new UserEntity();
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(userRegisterDto.getPassword());
        user.setEmail(userRegisterDto.getEmail());
        user.setFullName(userRegisterDto.getFullName());
        userRepository.save(user);
        return true;
    }

    public boolean login(LoginDto loginDto) {
        Optional<UserEntity> byUsernameAndPassword =
                userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (byUsernameAndPassword.isEmpty()) {
            return false;
        }
        loggedUser.login(byUsernameAndPassword.get());
        return true;

    }
}
