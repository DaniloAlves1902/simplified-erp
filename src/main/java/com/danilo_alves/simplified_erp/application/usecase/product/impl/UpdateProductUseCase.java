package com.danilo_alves.simplified_erp.application.usecase.product.impl;

import com.danilo_alves.simplified_erp.application.gateway.product.ProductGateway;
import com.danilo_alves.simplified_erp.application.usecase.product.UpdateProduct;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateProductUseCase implements UpdateProduct {
    private final ProductGateway productGateway;

    @Override
    public ProductDomain execute(ProductDomain productDomain) {
        if (productDomain == null || productDomain.getId() == null) {
            throw new IllegalArgumentException("ProductDomain or ProductDomain ID cannot be null");
        }
        return productGateway.update(productDomain);
    }
}