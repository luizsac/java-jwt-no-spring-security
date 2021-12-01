package com.spring.jwt.jwttutorial.service;

import com.spring.jwt.jwttutorial.entity.User;
import com.spring.jwt.jwttutorial.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserRegistrationService {

    private UserRepository userRepository;
    private TokenService tokenService;

    public User registrate(User user) {
        user.setToken(tokenService.generateToken(user));
        return userRepository.save(user);
    }

}
