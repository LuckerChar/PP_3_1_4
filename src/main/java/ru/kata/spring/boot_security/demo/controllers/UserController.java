package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userShow(@CurrentSecurityContext(expression = "authentication?.name") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }

//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String showAll(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "userView/showall";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") long id, Model model) {
//        model.addAttribute("user", userService.getUser(id));
//        return "userView/show";
//    }
//
//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "userView/new";
//    }
//
//    @PostMapping()
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/user";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") long id) {
//        model.addAttribute("user", userService.getUser(id));
//        return "userView/edit";
//    }
//
//    @PatchMapping("/{id}/edit")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
//        userService.updateUser(id, user);
//        return "redirect:/user";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") long id) {
//        userService.removeUser(id);
//        return "redirect:/user";
//    }
}
