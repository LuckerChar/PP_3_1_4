package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface UserService {
    void saveUser(User user);

    void updateUser(long id, User user);

    User getUser(long id);

    void removeUser(long id);

    List<User> getAllUsers();

    List<Role> getSetOfRoles(List<String> role);

}
