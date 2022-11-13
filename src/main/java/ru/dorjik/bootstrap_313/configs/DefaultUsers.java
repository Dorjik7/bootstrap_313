package ru.dorjik.bootstrap_313.configs;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.dorjik.bootstrap_313.models.User;
import ru.dorjik.bootstrap_313.service.UserService;

import java.util.Arrays;
import java.util.Collections;

@Component
public class DefaultUsers implements ApplicationRunner {
    private final UserService userService;

    public DefaultUsers(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void run(ApplicationArguments args){
        User admin = new User( "admin", "admin", "admin", "admin", 33, "admin@mail.ru", Collections.singleton("ROLE_ADMIN"));
        User user = new User( "user", "user", "user", "user", 22, "admin@mail.ru", Collections.singleton("ROLE_USER"));
        User multi = new User( "multi", "multi", "multi", "multi", 44, "multi@mail.ru", Arrays.asList("ROLE_USER","ROLE_ADMIN"));
        userService.addUser(admin);
        userService.addUser(user);
        userService.addUser(multi);
    }
}