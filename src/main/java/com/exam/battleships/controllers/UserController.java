package com.exam.battleships.controllers;

import com.exam.battleships.models.dtos.LoginDto;
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
    @ModelAttribute("loginDto")
    public LoginDto initLoginDto() {
        return new LoginDto();
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
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@Valid LoginDto loginDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() ){
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDto", bindingResult);

        return "redirect:/login";
        }
        if (!authService.login(loginDto)){
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            redirectAttributes.addFlashAttribute("IncorrectCredentials",true);
            return "redirect:/login";
        }
        return "redirect:/home";
    }

}
