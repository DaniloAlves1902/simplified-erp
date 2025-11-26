package com.danilo_alves.simplified_erp.application.usecase.user.impl;

import com.danilo_alves.simplified_erp.application.gateway.user.UserGateway;
import com.danilo_alves.simplified_erp.application.usecase.user.GetByUsernameUser;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetUserByUsernameUserUseCase implements GetByUsernameUser {
    private final UserGateway userGateway;

    @Override
    public UserDomain execute(String username) {
        return userGateway.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }
}
