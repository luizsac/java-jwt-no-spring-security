package com.spring.jwt.jwttutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginData {

    private String email;
    private String password;

}
