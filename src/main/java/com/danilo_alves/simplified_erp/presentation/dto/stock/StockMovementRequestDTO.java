package com.danilo_alves.simplified_erp.presentation.dto.stock;

import com.danilo_alves.simplified_erp.domain.entity.stock.enums.MovementDomain;

public record StockMovementRequestDTO(
        String productId,
        Integer quantity,
        MovementDomain movementType
) { }

