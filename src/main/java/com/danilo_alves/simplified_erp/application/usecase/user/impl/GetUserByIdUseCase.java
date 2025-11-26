package com.danilo_alves.simplified_erp.application.usecase.user.impl;

import com.danilo_alves.simplified_erp.application.gateway.user.UserGateway;
import com.danilo_alves.simplified_erp.application.usecase.user.GetByIdUser;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetUserByIdUseCase implements GetByIdUser {
    private final UserGateway userGateway;

    @Override
    public UserDomain execute(String id) {
        return userGateway.getById(id);
    }
}
