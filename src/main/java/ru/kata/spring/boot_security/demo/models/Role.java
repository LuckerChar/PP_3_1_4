package ru.kata.spring.boot_security.demo.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_roles")
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {

    }

    public Role(long id) {
        this.id = id;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        if (name.equals("ROLE_USER"))
            return "USER";
        return "ADMIN";
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}