package com.danilo_alves.simplified_erp.infrastructure.config.usecase;

import com.danilo_alves.simplified_erp.application.gateway.user.UserGateway;
import com.danilo_alves.simplified_erp.application.usecase.user.*;
import com.danilo_alves.simplified_erp.application.usecase.user.impl.*;
import com.danilo_alves.simplified_erp.infrastructure.decorator.TransactionalCreateUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserUseCaseConfig {
    @Bean
    public CreateUser createUser(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        CreateUser useCase = new CreateUserUseCase(userGateway, passwordEncoder);
        return new TransactionalCreateUser(useCase);
    }

    @Bean
    public UpdateUser updateUser(UserGateway userGateway) {
        return new UpdateUserUseCase(userGateway);
    }

    @Bean
    public DeleteUser deleteUser(UserGateway userGateway) {
        return new DeleteUserUseCase(userGateway);
    }

    @Bean
    public GetAllUser getAllUser(UserGateway userGateway) {
        return new GetAllUsersUseCase(userGateway);
    }

    @Bean
    public GetByIdUser getByIdUser(UserGateway userGateway) {
        return new GetUserByIdUseCase(userGateway);
    }

    @Bean
    public GetByUsernameUser getByUsername(UserGateway userGateway) {
        return new GetUserByUsernameUserUseCase(userGateway);
    }
}
