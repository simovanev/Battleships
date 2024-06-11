package com.exam.battleships.repositories;

import com.exam.battleships.models.dtos.LoginDto;
import com.exam.battleships.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsernameAndEmail(String username, String email );
}
