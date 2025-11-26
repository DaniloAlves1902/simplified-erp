package com.danilo_alves.simplified_erp.domain.factory;

import com.danilo_alves.simplified_erp.domain.entity.stock.enums.MovementDomain;
import com.danilo_alves.simplified_erp.domain.strategy.StockMovementStrategy;
import com.danilo_alves.simplified_erp.domain.strategy.impl.CreditStockStrategy;
import com.danilo_alves.simplified_erp.domain.strategy.impl.DebitStockStrategy;

import java.util.Map;

public class StockStrategyFactory {

    private static final Map<MovementDomain, StockMovementStrategy> STRATEGIES = Map.of(
            MovementDomain.SALE, new DebitStockStrategy(),
            MovementDomain.EXIT, new DebitStockStrategy(),
            MovementDomain.ENTRY, new CreditStockStrategy(),
            MovementDomain.PURCHASE, new CreditStockStrategy(),
            MovementDomain.RETURN, new CreditStockStrategy()
    );

    public static StockMovementStrategy getStrategy(MovementDomain type) {
        if (type == null) {
            throw new IllegalArgumentException("Movement type cannot be null");
        }

        StockMovementStrategy strategy = STRATEGIES.get(type);

        if (strategy == null) {
            throw new IllegalArgumentException("Strategy not defined for movement type: " + type);
        }

        return strategy;
    }
}