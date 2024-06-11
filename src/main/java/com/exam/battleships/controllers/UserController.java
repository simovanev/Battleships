package com.exam.battleships.controllers;

import com.exam.battleships.models.dtos.UserRegisterDto;
import com.exam.battleships.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("userRegisterDto")
    public UserRegisterDto initUserRegisterDto() {
           return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto
            ,BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || authService.register(userRegisterDto)) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDto", bindingResult);

            return "redirect:/register";
        }
        return "redirect:/login";
    }
}
