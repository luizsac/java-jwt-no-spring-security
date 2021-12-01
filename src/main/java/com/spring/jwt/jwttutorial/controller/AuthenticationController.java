package com.spring.jwt.jwttutorial.controller;

import com.spring.jwt.jwttutorial.dto.LoginData;
import com.spring.jwt.jwttutorial.dto.UserAutheticatedDTO;
import com.spring.jwt.jwttutorial.entity.User;
import com.spring.jwt.jwttutorial.service.UserAuthenticationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    private UserAuthenticationService userAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<UserAutheticatedDTO> authenticate(
            @RequestBody LoginData loginData, @RequestHeader String authorization) {
        User user = userAuthenticationService.authenticate(loginData, authorization);
        return new ResponseEntity<UserAutheticatedDTO>(new UserAutheticatedDTO(
                "Bearer ", user.getEmail(), user.getName(), user.getToken()), HttpStatus.ACCEPTED);
    }

}
