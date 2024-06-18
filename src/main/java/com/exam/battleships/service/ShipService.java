package com.exam.battleships.service;

import com.exam.battleships.models.dtos.AddShipDto;
import com.exam.battleships.models.enims.TypeEnum;
import com.exam.battleships.models.entities.CategoryEntity;
import com.exam.battleships.models.entities.Ship;
import com.exam.battleships.models.entities.UserEntity;
import com.exam.battleships.repositories.CategoryRepository;
import com.exam.battleships.repositories.ShipRepository;
import com.exam.battleships.repositories.UserRepository;
import com.exam.battleships.session.LoggedUser;
import com.fasterxml.jackson.databind.util.EnumValues;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private ShipRepository shipRepository;
    private ModelMapper modelMapper;
    private LoggedUser loggedUser;

    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public boolean create(AddShipDto addShipDto) {
        Optional<Ship> shipToAdd = shipRepository.findShipByName(addShipDto.getName());
        if (shipToAdd.isPresent()) {
            return false;
        }


        Ship ship = new Ship();
        modelMapper.map(addShipDto, ship);
        UserEntity owner = userRepository.findById(loggedUser.getId()).get();
        ship.setUser(owner);
        CategoryEntity category = categoryRepository.findByName(switch (addShipDto.getCategory()) {
            case 0 -> TypeEnum.BATTLE;
            case 1 -> TypeEnum.CARGO;
            case 2 -> TypeEnum.PATROL;
            default -> TypeEnum.BATTLE;
        });
        ship.setCategory(category);

        shipRepository.save(ship);
        return true;
    }
}
