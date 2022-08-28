package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class MyRestController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> allUsers(@ModelAttribute("user") User user) {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id, @ModelAttribute("user") User user) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<> (user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> changeUser(@RequestBody User user) {
        userService.updateUser(user.getId(), user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/auth")
    public ResponseEntity<User> principal(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }

}
