package com.danilo_alves.simplified_erp.application.usecase.user.impl;

import com.danilo_alves.simplified_erp.application.gateway.user.UserGateway;
import com.danilo_alves.simplified_erp.application.usecase.user.UpdateUser;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserUseCase implements UpdateUser {
    private final UserGateway userGateway;

    @Override
    public UserDomain execute(UserDomain userDomain) {
        if (userDomain == null || userDomain.getId() == null) {
            throw new IllegalArgumentException("UserDomain or UserDomain ID cannot be null");
        }
        return userGateway.update(userDomain);
    }
}
