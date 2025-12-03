package com.danilo_alves.simplified_erp.application.usecase.product.impl;

import com.danilo_alves.simplified_erp.application.gateway.product.ProductGateway;
import com.danilo_alves.simplified_erp.application.usecase.product.DeleteProduct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProductUseCase implements DeleteProduct {
    private final ProductGateway productGateway;

    @Override
    public Void execute(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id not found");
        }

        productGateway.delete(id);

        return null;
    }
}
