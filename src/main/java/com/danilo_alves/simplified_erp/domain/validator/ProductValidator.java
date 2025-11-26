package com.danilo_alves.simplified_erp.domain.validator;

import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;

public class ProductValidator {

    public static void validate(ProductDomain productDomain) {
        if (productDomain == null) {
            throw new IllegalArgumentException("ProductDomain cannot be null");
        }

        if (productDomain.getName() == null || productDomain.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("ProductDomain name is required");
        }

        if (productDomain.getSku() == null || productDomain.getSku().trim().isEmpty()) {
            throw new IllegalArgumentException("ProductDomain SKU is required");
        }

        if (productDomain.getPrice() == null || productDomain.getPrice() < 0) {
            throw new IllegalArgumentException("ProductDomain price must be non-negative");
        }

        if (productDomain.getStock() == null || productDomain.getStock() < 0) {
            throw new IllegalArgumentException("ProductDomain stock must be non-negative");
        }
    }
}
