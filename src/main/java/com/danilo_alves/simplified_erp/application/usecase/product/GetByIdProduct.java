package com.danilo_alves.simplified_erp.application.usecase.product;

import com.danilo_alves.simplified_erp.application.usecase.UseCase;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;

public interface GetByIdProduct extends UseCase<String, ProductDomain> {
}