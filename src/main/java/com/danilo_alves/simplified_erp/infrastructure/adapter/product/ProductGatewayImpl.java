package com.danilo_alves.simplified_erp.infrastructure.adapter.product;

import com.danilo_alves.simplified_erp.application.gateway.product.ProductGateway;
import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import com.danilo_alves.simplified_erp.domain.exception.product.ProductNotFoundException;
import com.danilo_alves.simplified_erp.infrastructure.mapper.product.ProductMapper;
import com.danilo_alves.simplified_erp.infrastructure.persistence.repository.ProductRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductGatewayImpl implements ProductGateway {
    private final ProductRepositoryJPA productRepositoryJPA;
    private final ProductMapper productMapper;

    @Override
    public ProductDomain save(ProductDomain product) {
        var entity = productMapper.toEntity(product);
        var saved = productRepositoryJPA.save(entity);
        return productMapper.toDomain(saved);
    }

    @Override
    public ProductDomain update(ProductDomain product) {
        productRepositoryJPA.findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException(product.getId()));

        var entity = productMapper.toEntity(product);
        var updateEntity = productRepositoryJPA.save(entity);

        return productMapper.toDomain(updateEntity);
    }

    @Override
    public void delete(String id) {
        if (!productRepositoryJPA.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepositoryJPA.deleteById(id);
    }

    @Override
    public List<ProductDomain> getAll() {
        return productRepositoryJPA.findAll().stream()
                .map(productMapper::toDomain)
                .toList();
    }

    @Override
    public ProductDomain getById(String id) {
        return productRepositoryJPA.findById(id)
                .map(productMapper::toDomain)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public boolean existsBySku(String sku) {
        return productRepositoryJPA.existsBySku(sku);
    }
}