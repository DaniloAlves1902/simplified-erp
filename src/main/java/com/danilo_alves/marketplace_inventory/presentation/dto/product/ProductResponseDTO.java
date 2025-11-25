package com.danilo_alves.marketplace_inventory.presentation.dto.product;

import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;

import java.util.List;
import java.util.stream.Collectors;

public record ProductResponseDTO(
        Long id,
        String sku,
        String name,
        String description,
        Double price,
        Integer stock

) {
    public static ProductResponseDTO fromDomain(ProductDomain domain) {
        return new ProductResponseDTO(
                domain.getId(),
                domain.getSku(),
                domain.getName(),
                domain.getDescription(),
                domain.getPrice(),
                domain.getStock()
        );
    }

    public static List<ProductResponseDTO> fromDomain(List<ProductDomain> domains) {
        return domains.stream()
                .map(ProductResponseDTO::fromDomain)
                .collect(Collectors.toList());
    }
}
