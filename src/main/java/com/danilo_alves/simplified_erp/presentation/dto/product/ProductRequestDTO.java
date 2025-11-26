package com.danilo_alves.simplified_erp.presentation.dto.product;

public record ProductRequestDTO(
        String sku,
        String name,
        String description,
        Double price,
        Integer stock,
        String currency
) {
}
