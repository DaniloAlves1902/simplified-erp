package com.danilo_alves.simplified_erp.domain.exception.product;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String sku) {
        super("Product with SKU: " + sku + " already exists.");
    }
}
