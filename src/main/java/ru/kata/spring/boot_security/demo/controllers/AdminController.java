//package ru.kata.spring.boot_security.demo.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//import org.springframework.web.bind.annotation.*;
//import ru.kata.spring.boot_security.demo.models.User;
//import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
//import ru.kata.spring.boot_security.demo.service.UserService;
//
//import java.util.List;
//
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//    private final UserService userService;
//    private final PasswordEncoder bCryptPasswordEncoder;
//    private final RoleRepository roleRepository;
//
//    @Autowired
//    public AdminController(UserService userService, PasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
//        this.userService = userService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.roleRepository = roleRepository;
//    }
//
//    @GetMapping("")
//    public String showAllUsers(Model model, @AuthenticationPrincipal User currentUser) {
//        User newUser = new User();
//        model.addAttribute("allUs", userService.getAllUsers());
//        model.addAttribute("currentUser", currentUser);
//        model.addAttribute("rolesList", roleRepository.findAll());
//        model.addAttribute("newUser", newUser);
//        return "admin/all_users";
//    }
//
//    @PostMapping("/create")
//    public String createUser(@ModelAttribute("newUser") User user, @RequestParam(value = "role") List<String> role) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(userService.findRolesByName(role));
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/update")
//    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "role") List<String> role) {
//        user.setRoles(userService.findRolesByName(role));
//        userService.update(user);
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUserById(id);
//        return "redirect:/admin";
//    }
//}
