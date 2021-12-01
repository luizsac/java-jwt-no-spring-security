package com.spring.jwt.jwttutorial.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.spring.jwt.jwttutorial.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UserRegistrationDTO extends User {

    private Long id;
    private String name;
    private String email;
    private String password;

    public User toUser() {
        return new User(name, email, password);
    }

}
