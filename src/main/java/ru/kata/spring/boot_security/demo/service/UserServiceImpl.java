package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        if (userRepository.findByEmail(user.getEmail())!=null){
            throw new RuntimeException();
        }
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void updateUser(long id, User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public List<Role> getSetOfRoles(List<String> rolesId) {
        List<Role> roleSet = new ArrayList<>();
        for (String id : rolesId) {
            roleSet.add(roleRepository.getRoleById(Long.parseLong(id)));
        }
        return roleSet;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("USER NF");
        }
        return user;
    }

}
