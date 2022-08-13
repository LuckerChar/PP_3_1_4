package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.io.Serializable;
import java.util.List;


public interface UserService {
    Serializable saveUser(User user);

    void update(User user);

    User getUser(long id);

    void deleteUserById(long id);

    List<User> getAllUsers();

    List<Role> findRolesByName(List<String> role);

    User findByEmail(String name);
}
