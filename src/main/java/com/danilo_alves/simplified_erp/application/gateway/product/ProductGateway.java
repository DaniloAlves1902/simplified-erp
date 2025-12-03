package com.danilo_alves.simplified_erp.application.gateway.product;

import com.danilo_alves.simplified_erp.application.gateway.Gateway;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;

public interface ProductGateway extends Gateway<ProductDomain, String> {
    boolean existsBySku(String sku);
}
