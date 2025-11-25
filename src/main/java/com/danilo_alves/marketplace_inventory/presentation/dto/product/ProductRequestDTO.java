package com.danilo_alves.marketplace_inventory.presentation.dto.product;

public record ProductRequestDTO(
        String sku,
        String name,
        String description,
        Double price,
        Integer stock
) {
}
