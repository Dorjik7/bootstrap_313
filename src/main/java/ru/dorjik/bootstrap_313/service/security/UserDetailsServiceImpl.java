package ru.dorjik.bootstrap_313.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dorjik.bootstrap_313.dao.UserDao;
import ru.dorjik.bootstrap_313.models.User;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public AccountDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = userDao.findByUsername(username);
//        if (user.size() != 1) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new AccountDetails(user.get(0));
//    }
            if (user == null) {
                throw new UsernameNotFoundException("User is not found");
            }

            return new AccountDetails(user.get(0));
        }

    }


