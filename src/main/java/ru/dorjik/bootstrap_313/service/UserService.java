package ru.dorjik.bootstrap_313.service;
import ru.dorjik.bootstrap_313.models.User;
import java.util.List;


public interface UserService {
    void addUser(User user);

    List<User> userList();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);

}
