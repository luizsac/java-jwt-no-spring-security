package com.spring.jwt.jwttutorial.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UserResponderDTO {

    private Long id;
    private String name;
    private String email;
    private String password;

    @Builder
    public UserResponderDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}