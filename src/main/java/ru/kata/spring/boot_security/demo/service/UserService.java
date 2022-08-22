package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;


public interface UserService {
    void saveUser(User user);

    void update(long id, User user);

    void deleteUserById(long id);

    List<User> getAllUsers();

    User findById(Long id);

    List<Role> findRolesByName(List<String> roleName);

    List<Role> getAllRoles();

}
