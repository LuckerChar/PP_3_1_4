package ru.kata.spring.boot_security.demo.Repository;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        String jpql = "from User";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    public List<Role> getAllRoles() {
        String jpql = "from Role";
        TypedQuery<Role> query = entityManager.createQuery(jpql, Role.class);
        return query.getResultList();
    }

    public List<String> getAllEmails() {
        List<String> emails = new ArrayList<>();
        getAllUsers().forEach(user -> emails.add(user.getEmail()));
        return emails;
    }


    public void saveUser(User user) {
        entityManager.persist(user);

    }

    public void saveRole(Role role) {
        entityManager.persist(role);

    }


    public void removeUserById(long id) {
        entityManager.remove(getUserById(id));
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        TypedQuery<User> query = entityManager.createQuery("from User where email = :email", User.class);
        query.setParameter("email", name);
        return query.getSingleResult();
    }


    public void changeUserById(long id, User user) {
        user.setId(id);
        entityManager.merge(user);
    }


}