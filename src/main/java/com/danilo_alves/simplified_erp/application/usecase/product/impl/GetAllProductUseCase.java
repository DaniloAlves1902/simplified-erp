package com.danilo_alves.simplified_erp.application.usecase.product.impl;

import com.danilo_alves.simplified_erp.application.gateway.product.ProductGateway;
import com.danilo_alves.simplified_erp.application.usecase.product.GetAllProduct;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllProductUseCase implements GetAllProduct {
    private final ProductGateway productGateway;

    @Override
    public List<ProductDomain> execute(Void input) {
        return productGateway.getAll();
    }
}