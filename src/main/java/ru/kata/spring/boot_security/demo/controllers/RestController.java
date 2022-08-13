package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.forms.UserFormCreateApi;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api")
public class RestController {

    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping()
    public UserFormCreateApi createNewUser(@RequestBody UserFormCreateApi user) {

        User newUser = User.builder().username(user.getUsername()).surname(user.getSurname()).email(user.getEmail()).age(user.getAge()).password(user.getPassword()).build();

        newUser.setRoles(userService.getSetOfRoles(Collections.singletonList(user.getRoles())));
        userService.saveUser(newUser);
        return user;
    }

    @PutMapping
    public UserFormCreateApi updateUser(@RequestBody UserFormCreateApi user) {
        User newUser = User.builder().id(user.getId()).username(user.getUsername()).surname(user.getSurname()).email(user.getEmail()).age(user.getAge()).password(user.getPassword()).build();
        newUser.setRoles(userService.getSetOfRoles(Collections.singletonList(user.getRoles())));
        userService.updateUser(newUser);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "OK";
    }
}