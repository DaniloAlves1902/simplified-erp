package com.danilo_alves.simplified_erp.application.usecase.user.impl;

import com.danilo_alves.simplified_erp.application.gateway.user.UserGateway;
import com.danilo_alves.simplified_erp.application.usecase.user.GetAllUser;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllUsersUseCase implements GetAllUser {
    private final UserGateway userGateway;

    @Override
    public List<UserDomain> execute(Void input) {
        return userGateway.getAll();
    }
}
