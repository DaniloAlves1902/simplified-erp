package com.danilo_alves.simplified_erp.infrastructure.decorator;

import com.danilo_alves.simplified_erp.application.usecase.product.CreateProduct;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class TransactionalCreateProduct implements CreateProduct {

    private final CreateProduct decorated;

    @Override
    @Transactional
    public ProductDomain execute(ProductDomain productDomain) {
        return decorated.execute(productDomain);
    }
}