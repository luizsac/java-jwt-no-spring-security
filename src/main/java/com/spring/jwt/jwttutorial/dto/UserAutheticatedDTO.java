package com.spring.jwt.jwttutorial.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UserAutheticatedDTO {

    private String type;
    private String email;
    private String name;
    private String token;

}
