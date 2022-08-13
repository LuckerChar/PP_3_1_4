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
    private String username;
    private String surname;
    private String email;
    private Integer age;
    private String password;
    private String roles;
}
