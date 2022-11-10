package ru.dorjik.bootstrap_313.dao;

import ru.dorjik.bootstrap_313.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void addUser(User user);

    List<User> listUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);

    List<User> findByUsername(String username);
}