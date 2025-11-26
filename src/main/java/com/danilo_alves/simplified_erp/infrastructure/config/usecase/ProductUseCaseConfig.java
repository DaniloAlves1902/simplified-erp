package com.danilo_alves.simplified_erp.infrastructure.config.usecase;

import com.danilo_alves.simplified_erp.application.gateway.product.ProductGateway;
import com.danilo_alves.simplified_erp.application.usecase.product.*;
import com.danilo_alves.simplified_erp.application.usecase.product.impl.*;
import com.danilo_alves.simplified_erp.infrastructure.decorator.TransactionalCreateProduct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCaseConfig {

    @Bean
    public CreateProduct createProduct(ProductGateway productGateway) {
        CreateProductUseCase useCase = new CreateProductUseCase(productGateway);
        return new TransactionalCreateProduct(useCase);
    }

    @Bean
    public UpdateProduct updateProduct(ProductGateway productGateway) {
        return new UpdateProductUseCase(productGateway);
    }

    @Bean
    public DeleteProduct deleteProduct(ProductGateway productGateway) {
        return new DeleteProductUseCase(productGateway);
    }

    @Bean
    public GetAllProduct getAllProduct(ProductGateway productGateway) {
        return new GetAllProductUseCase(productGateway);
    }

    @Bean
    public GetByIdProduct getByIdProduct(ProductGateway productGateway) {
        return new GetByIdProductUseCase(productGateway);
    }
}