package com.danilo_alves.simplified_erp.application.usecase.stock.impl;

import com.danilo_alves.simplified_erp.application.gateway.stock.StockGateway;
import com.danilo_alves.simplified_erp.application.usecase.stock.GetAllStockMovement;
import com.danilo_alves.simplified_erp.domain.entity.stock.StockMovementDomain;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllStockMovementUseCase implements GetAllStockMovement {
    private final StockGateway stockGateway;

    @Override
    public List<StockMovementDomain> execute(Void input) {
        return stockGateway.getAll();
    }
}
