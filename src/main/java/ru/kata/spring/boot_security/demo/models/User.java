package ru.kata.spring.boot_security.demo.models;


import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 1, max = 15, message = "min 1, max 15")
    @Column(name = "firstName")
    private String firstName;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 1, max = 15, message = "min 1, max 15")
    @Column(name = "lastName")
    private String lastName;

    @NotEmpty(message = "Age can't be empty")
    @Size(min = 1, max = 3, message = "min 1, max 3")
    @Column(name = "age")
    private byte age;

    @NotEmpty(message = "Mail can't be empty")
    @Email(message = "It's not email")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 1, max = 15, message = "min 1, max 15")
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Fetch(FetchMode.JOIN)
    private Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return firstName;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}