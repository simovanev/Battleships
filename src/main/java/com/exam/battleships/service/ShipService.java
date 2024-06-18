package com.exam.battleships.service;

import com.exam.battleships.models.dtos.AddShipDto;
import com.exam.battleships.models.entities.Ship;
import com.exam.battleships.models.entities.UserEntity;
import com.exam.battleships.repositories.ShipRepository;
import com.exam.battleships.repositories.UserRepository;
import com.exam.battleships.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {
    private final UserRepository userRepository;
    private ShipRepository shipRepository;
    private ModelMapper modelMapper;
    private LoggedUser loggedUser;

    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean create(AddShipDto addShipDto) {
        Optional<Ship> shipToAdd = shipRepository.findShipByName(addShipDto.getName());
        if (shipToAdd.isPresent() ){
            return false;
        }


        Ship ship = new Ship();
        modelMapper.map(addShipDto, ship);
        UserEntity owner=userRepository.findById(loggedUser.getId()).get();
        ship.setUser(owner);

        shipRepository.save(ship);
        return true;
    }
}
