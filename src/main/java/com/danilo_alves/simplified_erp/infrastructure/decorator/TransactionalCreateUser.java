package com.danilo_alves.simplified_erp.infrastructure.decorator;

import com.danilo_alves.simplified_erp.application.usecase.user.CreateUser;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class TransactionalCreateUser implements CreateUser {

    private final CreateUser decorated;

    @Override
    @Transactional
    public UserDomain execute(UserDomain userDomain) {
        return decorated.execute(userDomain);
    }
}
