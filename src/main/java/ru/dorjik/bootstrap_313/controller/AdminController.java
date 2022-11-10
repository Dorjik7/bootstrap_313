package ru.dorjik.bootstrap_313.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dorjik.bootstrap_313.models.User;
import ru.dorjik.bootstrap_313.service.security.AccountDetails;
import ru.dorjik.bootstrap_313.service.security.UserService;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class AdminController {
    private UserService adminService;

    public AdminController(UserService adminService) {
        this.adminService =adminService;
    }

    @GetMapping("/user")
    public String showUser(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
        model.addAttribute("user", accountDetails.getUser());
        return "user";
    }

    @GetMapping("/")
    public String showUsers(Model model) {

        if (adminService.listUsers().isEmpty())
            adminService.addUser(new User("admin", "admin", Arrays.asList("ROLE_ADMIN")));
        model.addAttribute("users", adminService.listUsers());
        User user = new User();
        model.addAttribute("newUser", user);
        return "admin";
    }

    @PostMapping("/admin/register")
    public String inputUser(@ModelAttribute("user") User user) {

        adminService.addUser(user);
        return "redirect:/";
    }

    @PatchMapping("/admin/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") Long id) {

        adminService.editUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") Long id) {

        adminService.deleteUser(id);
        return "redirect:/";
    }
}


