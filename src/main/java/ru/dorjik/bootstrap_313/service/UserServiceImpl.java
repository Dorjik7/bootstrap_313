package ru.dorjik.bootstrap_313.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dorjik.bootstrap_313.dao.UserDao;
import ru.dorjik.bootstrap_313.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {

        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void addUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> userList() {
        return userDao.listUsers();
    }


    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {

        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void editUser(Long id, User user) {

        if (user.getPassword() == "") {
            user.setPassword(userDao.getUser(id).getPassword());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userDao.editUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {

        userDao.deleteUser(id);
    }
}


