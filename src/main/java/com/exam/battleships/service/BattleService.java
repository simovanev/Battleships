package com.exam.battleships.service;

import com.exam.battleships.models.dtos.BattleDto;
import com.exam.battleships.models.entities.Ship;
import com.exam.battleships.repositories.ShipRepository;
import org.springframework.data.repository.query.ParameterOutOfBoundsException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {

    private final ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void attack(BattleDto battleDto) {
        Optional<Ship> attackerOpt = shipRepository.findById(battleDto.getAttackerId());
        Optional<Ship> defenderOpt = shipRepository.findById(battleDto.getDefenderId());
        if (attackerOpt.isEmpty() || defenderOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        Ship attacker = attackerOpt.get();
        Ship defender = defenderOpt.get();

         long newHealth=defender.getHealth()-attacker.getPower();
         if(newHealth<=0) {
             shipRepository.delete(defender);
         }else {defender.setHealth(newHealth);
         shipRepository.save(defender);
         }

    }
}
