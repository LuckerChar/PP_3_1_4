package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminController(UserService userService, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @GetMapping()
    public String showAll(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/showall";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("users", userService.getUser(id));
        return "admin/show";
    }

    @GetMapping("/new")
    public String addNewUser(ModelMap model) {
        model.addAttribute("users", new User());
        model.addAttribute("roles",roleRepository.findAll());
        return "admin/new";
    }

    @PostMapping()
    private String createUser(@ModelAttribute("users") User user,
                              @RequestParam(value = "roles", required = false) Set<Role> roles) {
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "admin/edit";
    }

    @PatchMapping
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id,
                         @RequestParam(value = "roles", required = false) Set<Role> roles) {
        if (!user.getPassword().equals(userService.getUser(user.getId()).getPassword())){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        user.setRoles(roles);
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/admin";

    }

}

