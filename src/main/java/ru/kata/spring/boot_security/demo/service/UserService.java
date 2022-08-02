package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(long id, User user);
    User getUser(long id);
    void removeUser(long id);
    List<User> getAllUsers();
}
