package ru.dorjik.bootstrap_313.dao;

import ru.dorjik.bootstrap_313.models.Role;
import ru.dorjik.bootstrap_313.models.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> listUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);

    List<User> findByUsername(String username);
    Role findById(long id);
    Role getRoleByName (String name);

}