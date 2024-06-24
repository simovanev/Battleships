package com.exam.battleships.controllers;

import com.exam.battleships.models.dtos.ShipDto;
import com.exam.battleships.service.ShipService;
import com.exam.battleships.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class HomeController {
    private final ShipService shipService;
    private final LoggedUser loggedUser;

    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public String LoggedOutIndex(){
        return "index";
    }
    @GetMapping("/home")
    public String LoggedInIndex(Model model) {

        long ownerId= loggedUser.getId();
        List<ShipDto> ownShips= shipService.getShipsOwnedBy(ownerId);
        List<ShipDto> enemyShips= shipService.getShipsNotOwnedBy(ownerId);

        model.addAttribute("ownShips", ownShips);
        model.addAttribute("enemyShips",enemyShips );
        return "home";
    }
}
