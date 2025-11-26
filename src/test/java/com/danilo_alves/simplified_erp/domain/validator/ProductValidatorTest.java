package com.danilo_alves.simplified_erp.domain.validator;

import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidatorTest {

    @Test
    void shouldNotThrowExceptionWhenProductIsValid() {
        ProductDomain validProduct = new ProductDomain();
        validProduct.setName("Valid Product");
        validProduct.setSku("SKU123");
        validProduct.setPrice(100.00);
        validProduct.setStock(10);

        assertDoesNotThrow(() -> ProductValidator.validate(validProduct));
    }

    @Test
    void shouldThrowExceptionWhenProductDomainIsNull() {
        ProductDomain invalidProduct = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenProductNameIsNull() {
        ProductDomain invalidProduct = new ProductDomain();
        invalidProduct.setSku("SKU123");
        invalidProduct.setPrice(100.00);
        invalidProduct.setStock(10);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain name is required", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenProductNameIsEmpty() {
        ProductDomain invalidProduct = new ProductDomain();
        invalidProduct.setName("   ");
        invalidProduct.setSku("SKU123");
        invalidProduct.setPrice(100.00);
        invalidProduct.setStock(10);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain name is required", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenProductSkuIsNull() {
        ProductDomain invalidProduct = new ProductDomain();
        invalidProduct.setName("Product without SKU");
        invalidProduct.setPrice(100.00);
        invalidProduct.setStock(10);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain SKU is required", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenProductSkuIsEmpty() {
        ProductDomain invalidProduct = new ProductDomain();
        invalidProduct.setName("Product without SKU");
        invalidProduct.setSku("   ");
        invalidProduct.setPrice(100.00);
        invalidProduct.setStock(10);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain SKU is required", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenProductPriceIsNull() {
        ProductDomain invalidProduct = new ProductDomain();
        invalidProduct.setName("Product without Price");
        invalidProduct.setSku("SKU123");
        invalidProduct.setPrice(null);
        invalidProduct.setStock(10);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain price must be non-negative", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenProductPriceIsNegative() {
        ProductDomain invalidProduct = new ProductDomain();
        invalidProduct.setName("Product with Negative Price");
        invalidProduct.setSku("SKU123");
        invalidProduct.setPrice(-100.00);
        invalidProduct.setStock(10);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain price must be non-negative", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenProductStockIsNull() {
        ProductDomain invalidProduct = new ProductDomain();
        invalidProduct.setName("Product without Stock");
        invalidProduct.setSku("SKU123");
        invalidProduct.setPrice(100.00);
        invalidProduct.setStock(null);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain stock must be non-negative", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenProductStockIsNegative() {
        ProductDomain invalidProduct = new ProductDomain();
        invalidProduct.setName("Product with Negative Stock");
        invalidProduct.setSku("SKU123");
        invalidProduct.setPrice(100.00);
        invalidProduct.setStock(-10);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ProductValidator.validate(invalidProduct));

        assertEquals("ProductDomain stock must be non-negative", exception.getMessage());
    }
}