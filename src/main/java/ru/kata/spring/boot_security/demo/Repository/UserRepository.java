package ru.kata.spring.boot_security.demo.Repository;


import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);
    public void saveRole(Role role);

    void removeUserById(long id);

    User getUserById(long id);
    User getUserByName(String name);
    void changeUserById(long id, User user);

    List<User> getAllUsers();
    List<Role> getAllRoles();
    List<String> getAllEmails();


}