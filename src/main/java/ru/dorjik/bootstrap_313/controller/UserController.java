package ru.dorjik.bootstrap_313.controller;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dorjik.bootstrap_313.models.User;
import ru.dorjik.bootstrap_313.service.security.UserService;


@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String userInfo(@CurrentSecurityContext(expression = "authentication.principal") User principal,
                           Model model) {
        model.addAttribute("user", principal);

        return "user";
    }

}