package com.spring.jwt.jwttutorial.controller;

import com.spring.jwt.jwttutorial.dto.UserAutheticatedDTO;
import com.spring.jwt.jwttutorial.dto.UserRegistrationDTO;
import com.spring.jwt.jwttutorial.entity.User;
import com.spring.jwt.jwttutorial.service.UserRegistrationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @PostMapping("/user")
    public ResponseEntity<UserAutheticatedDTO> registrate(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        User user = userRegistrationService.registrate((userRegistrationDTO.toUser()));
        return new ResponseEntity<>(new UserAutheticatedDTO(
                "Bearer ", user.getEmail(), user.getName(), user.getToken()), HttpStatus.CREATED);
    }

}
