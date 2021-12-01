package com.spring.jwt.jwttutorial.service;

import com.spring.jwt.jwttutorial.dto.LoginData;
import com.spring.jwt.jwttutorial.entity.User;
import com.spring.jwt.jwttutorial.exception.EmailNotFoundException;
import com.spring.jwt.jwttutorial.exception.ExpiredTokenException;
import com.spring.jwt.jwttutorial.exception.InvalidLoginException;
import com.spring.jwt.jwttutorial.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UserAuthenticationService {

    private final UserRepository userRepository;
    private final TokenService tokenService;

    public User authenticate(LoginData data, String token) {
        User user = userRepository.findByEmail(data.getEmail()).orElseThrow(EmailNotFoundException::new);
        if (data.getPassword().equals(user.getPassword()) && !token.isEmpty() && validate(token))
            return user;
        else
            throw new InvalidLoginException();
    }

    private boolean validate(String token) {
        try {
            token = token.replace("Bearer ", "");
            Claims claims = tokenService.decodeToken(token);

            //verifica se token já expirou
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            return true;
        } catch (ExpiredTokenException ete) {
            ete.printStackTrace();
            throw new InvalidLoginException();
        }
    }

}
