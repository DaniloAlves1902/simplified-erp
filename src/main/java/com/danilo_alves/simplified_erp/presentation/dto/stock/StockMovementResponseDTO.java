package com.danilo_alves.simplified_erp.presentation.dto.stock;

import com.danilo_alves.simplified_erp.domain.entity.stock.StockMovementDomain;
import com.danilo_alves.simplified_erp.domain.entity.stock.enums.MovementDomain;

import java.time.OffsetDateTime;

public record StockMovementResponseDTO(
        Long id,
        String productName,
        Integer quantity,
        MovementDomain type,
        OffsetDateTime timestamp,
        String responsible
) {
    public static StockMovementResponseDTO fromDomain(StockMovementDomain domain) {
        return new StockMovementResponseDTO(
                domain.getId(),
                domain.getProduct() != null ? domain.getProduct().getName() : "Unknown Product",
                domain.getQuantityChanged(),
                domain.getMovementTypeDomain(),
                domain.getTimeStamp(),
                domain.getChangedBy() != null ? domain.getChangedBy().getUsername() : "System"
        );
    }
}