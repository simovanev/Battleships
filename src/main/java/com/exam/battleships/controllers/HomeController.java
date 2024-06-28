package com.exam.battleships.controllers;

import com.exam.battleships.models.dtos.BattleDto;
import com.exam.battleships.models.dtos.ShipDto;
import com.exam.battleships.models.entities.Ship;
import com.exam.battleships.service.ShipService;
import com.exam.battleships.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller

public class HomeController {
    private final ShipService shipService;
    private final LoggedUser loggedUser;

    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("battleDto")
    public BattleDto battleships() {
        return new BattleDto();
    }

    @GetMapping("/")
    public String LoggedOutIndex() {
        return "index";
    }

    @GetMapping("/home")
    public String LoggedInIndex(Model model) {

        long ownerId = loggedUser.getId();
        if (ownerId == 0) {
            return "redirect:/";
        }
        List<ShipDto> ownShips = shipService.getShipsOwnedBy(ownerId);
        List<ShipDto> enemyShips = shipService.getShipsNotOwnedBy(ownerId);
        List<ShipDto> allShips = shipService.getAllShips();

        model.addAttribute("ownShips", ownShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("allShips", allShips);
        return "home";
    }
}
