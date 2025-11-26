package com.danilo_alves.simplified_erp.application.usecase.user.impl;

import com.danilo_alves.simplified_erp.application.gateway.user.UserGateway;
import com.danilo_alves.simplified_erp.application.usecase.user.DeleteUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteUserUseCase implements DeleteUser {
    private final UserGateway userGateway;

    @Override
    public Void execute(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id not found");
        }

        userGateway.delete(id);
        return null;
    }
}
