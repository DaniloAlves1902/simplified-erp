package com.danilo_alves.simplified_erp.infrastructure.config.usecase;

import com.danilo_alves.simplified_erp.application.gateway.stock.StockGateway;
import com.danilo_alves.simplified_erp.application.usecase.stock.impl.GetAllStockMovementUseCase;
import com.danilo_alves.simplified_erp.application.usecase.stock.impl.RegisterStockMovementUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterStockMovementUseCaseConfig {

    @Bean
    public RegisterStockMovementUseCase registerStockMovementUseCase(StockGateway stockGateway) {
        return new RegisterStockMovementUseCase(stockGateway);
    }

    @Bean
    GetAllStockMovementUseCase getAllStockMovementUseCase(StockGateway stockGateway) {
        return new GetAllStockMovementUseCase(stockGateway);
    }
}
