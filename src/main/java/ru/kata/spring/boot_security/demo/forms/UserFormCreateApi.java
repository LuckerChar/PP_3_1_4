package ru.kata.spring.boot_security.demo.forms;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserFormCreateApi {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Byte age;
    private String password;
    private String roles;
}
