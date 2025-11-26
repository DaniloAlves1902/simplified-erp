package com.danilo_alves.simplified_erp.application.usecase.product.impl;

import com.danilo_alves.simplified_erp.application.gateway.product.ProductGateway;
import com.danilo_alves.simplified_erp.application.usecase.product.GetByIdProduct;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetByIdProductUseCase implements GetByIdProduct {
    private final ProductGateway productGateway;

    @Override
    public ProductDomain execute(Long id) {
        return productGateway.getById(id);
    }
}
