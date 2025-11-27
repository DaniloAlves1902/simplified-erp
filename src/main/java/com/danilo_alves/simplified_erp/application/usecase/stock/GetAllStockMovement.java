package com.danilo_alves.simplified_erp.application.usecase.stock;

import com.danilo_alves.simplified_erp.application.usecase.UseCase;
import com.danilo_alves.simplified_erp.domain.entity.stock.StockMovementDomain;

import java.util.List;

public interface GetAllStockMovement extends UseCase<Void, List<StockMovementDomain>> {
}
