package com.exam.battleships.repositories;

import com.exam.battleships.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Integer> {
    Optional<Ship> findShipByName(String name);
}
