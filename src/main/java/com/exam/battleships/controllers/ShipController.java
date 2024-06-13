package com.exam.battleships.controllers;

import com.exam.battleships.models.dtos.AddShipDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {
    @ModelAttribute("addShipDto")
    public AddShipDto initShipDto() {
        return new AddShipDto();
    }

    @GetMapping("/ship/add")
    public String shipAdd() {
        return "ship-add";
    }

    @PostMapping("/ship/add")
    public String shipAdd(@Valid AddShipDto addShipDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addShipDto", addShipDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShipDto, bindingResult");
            return "redirect:/ship/add";
        }
        return "redirect:/home";
    }
}
