package com.exam.battleships.controllers;

import com.exam.battleships.models.dtos.BattleDto;
import com.exam.battleships.service.BattleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class BattleController {
    private BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/battle")
    public String battle(@Valid BattleDto battleDto){
        battleService.attack(battleDto);
        return "redirect:/home";
    }
}
