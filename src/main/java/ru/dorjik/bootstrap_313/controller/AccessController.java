package ru.dorjik.bootstrap_313.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dorjik.bootstrap_313.models.User;
import ru.dorjik.bootstrap_313.service.UserService;
import ru.dorjik.bootstrap_313.service.security.AccountDetails;

@Controller
@RequestMapping("/")
public class AccessController {
    private final UserService service;

    public AccessController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public String userProfile(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
        model.addAttribute("user", accountDetails.getUser());
        return "user";
    }

    @GetMapping("/")
    public String adminPanel(Model model) {
        model.addAttribute("users", service.userList());
        User user = new User();
        model.addAttribute("newUser", user);
        return "admin";
    }

    @PostMapping("/admin/register")
    public String addNewUser(@ModelAttribute("user") User user) {

        service.addUser(user);
        return "redirect:/";
    }

    @PatchMapping("/admin/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {

        service.editUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        service.deleteUser(id);
        return "redirect:/";
    }
}


