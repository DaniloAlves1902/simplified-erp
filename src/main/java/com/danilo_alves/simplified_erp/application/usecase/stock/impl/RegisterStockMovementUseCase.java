package com.danilo_alves.simplified_erp.application.usecase.stock.impl;

import com.danilo_alves.simplified_erp.application.gateway.stock.StockGateway;
import com.danilo_alves.simplified_erp.application.usecase.stock.RegisterStockMovement;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import com.danilo_alves.simplified_erp.domain.entity.stock.StockMovementDomain;
import com.danilo_alves.simplified_erp.domain.exception.product.ProductNotFoundException;
import com.danilo_alves.simplified_erp.domain.factory.StockStrategyFactory;
import com.danilo_alves.simplified_erp.domain.strategy.StockMovementStrategy;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
public class RegisterStockMovementUseCase implements RegisterStockMovement {
    private final StockGateway stockGateway;

    @Override
    public StockMovementDomain execute(StockMovementDomain movement) {
        Long productId = movement.getProduct().getId();
        ProductDomain product = stockGateway.findProductById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        StockMovementStrategy strategy = StockStrategyFactory.getStrategy(movement.getMovementTypeDomain());
        strategy.execute(product, movement.getQuantityChanged());

        movement.setProduct(product);
        movement.setTimeStamp(OffsetDateTime.now());

        StockMovementDomain savedMovement = stockGateway.updateStock(product, movement);

        return savedMovement;
    }
}
