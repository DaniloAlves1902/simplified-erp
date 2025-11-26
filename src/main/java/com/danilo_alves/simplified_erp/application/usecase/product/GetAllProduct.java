package com.danilo_alves.simplified_erp.application.usecase.product;

import com.danilo_alves.simplified_erp.application.usecase.UseCase;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import java.util.List;

public interface GetAllProduct extends UseCase<Void, List<ProductDomain>> {
}