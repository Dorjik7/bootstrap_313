package ru.dorjik.bootstrap_313.service;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.dorjik.bootstrap_313.models.User;
import java.util.Collections;

@Component
public class InitiateDB implements ApplicationRunner {
    private final UserService userService;

    public InitiateDB(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void run(ApplicationArguments args){
        User admin = new User( "admin", "admin", "admin", "admin",22, "admin@mail.ru", Collections.singleton("ROLE_ADMIN"));
        User user = new User( "user", "user", "user", "user",21, "user@mail.ru", Collections.singleton("ROLE_USER"));
        userService.addUser(admin);
        userService.addUser(user);
    }
}