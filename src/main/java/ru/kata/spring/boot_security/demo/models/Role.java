package ru.kata.spring.boot_security.demo.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name ="name_role")
    private String nameRole;

    @Override
    public String getAuthority() {
        return getAuthority();
    }
}
