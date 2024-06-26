package com.exam.battleships.repositories;

import com.exam.battleships.models.dtos.ShipDto;
import com.exam.battleships.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Integer> {
    Optional<Ship> findShipByName(String name);

    List<Ship> findByUserId(long ownerId);

    List<Ship> findByUserIdNot(long ownerId);

    List<Ship> findBy();
}
