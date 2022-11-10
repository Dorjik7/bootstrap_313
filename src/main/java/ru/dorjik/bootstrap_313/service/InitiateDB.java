package ru.dorjik.bootstrap_313.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.dorjik.bootstrap_313.models.User;

import java.util.Collections;

@Component
public class InitiateDB implements ApplicationRunner {
    private final UserService usersService;

    public InitiateDB(UserService usersService) {
        this.usersService = usersService;
    }
    @Override
    public void run(ApplicationArguments args){
        User admin = new User( "admin", "admin", "admin", "admin",26, "admin@mail", Collections.singleton("ROLE_ADMIN"));
        User user = new User( "user", "user", "user", "user",26, "admin@mail", Collections.singleton("ROLE_USER"));
        usersService.addUser(admin);
        usersService.addUser(user);
    }
}