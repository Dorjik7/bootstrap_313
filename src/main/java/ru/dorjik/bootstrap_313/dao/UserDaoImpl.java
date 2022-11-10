package ru.dorjik.bootstrap_313.dao;
import org.springframework.stereotype.Repository;
import ru.dorjik.bootstrap_313.models.Role;
import ru.dorjik.bootstrap_313.models.User;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;


    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {

        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }

    @Override
    public User getUser(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(Long id, User user) {

        User edit = entityManager.find(User.class, id);
        edit.setUsername(user.getUsername());
        edit.setFirstName(user.getFirstName());
        edit.setSecondName(user.getSecondName());
        edit.setAge(user.getAge());
        edit.setEmail(user.getEmail());
        edit.setPassword(user.getPassword());
        edit.setRoles(user.getRoles());
    }

    @Override
    public void deleteUser(Long id) {

        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findByUsername(String username) {

        return entityManager.createQuery("select u from User u join fetch u.roles where u.username =:username").setParameter("username", username).getResultList();
    }
    @Override
    public Role findById(long id) {
        return entityManager.find(Role.class,id);
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.find(Role.class, name);
    }
}
