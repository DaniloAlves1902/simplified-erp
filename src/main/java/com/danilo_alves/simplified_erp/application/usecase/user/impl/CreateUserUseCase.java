package com.danilo_alves.simplified_erp.application.usecase.user.impl;

import com.danilo_alves.simplified_erp.application.gateway.user.UserGateway;
import com.danilo_alves.simplified_erp.application.usecase.user.CreateUser;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import com.danilo_alves.simplified_erp.domain.exception.user.UserAlreadyExistsException;
import com.danilo_alves.simplified_erp.domain.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class CreateUserUseCase implements CreateUser {
    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder; // Adicione

    @Override
    public UserDomain execute(UserDomain userDomain) {
        UserValidator.validate(userDomain);
        if (userGateway.existsByUsername(userDomain.getUsername())) {
            throw new UserAlreadyExistsException(userDomain.getUsername());
        }

        userDomain.setPassword(passwordEncoder.encode(userDomain.getPassword()));

        return userGateway.save(userDomain);
    }
}
