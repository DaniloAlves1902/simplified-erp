package com.danilo_alves.simplified_erp.infrastructure.persistence.repository;

import com.danilo_alves.simplified_erp.infrastructure.persistence.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<ProductEntity, Long> {
    boolean existsBySku(String sku);
}
