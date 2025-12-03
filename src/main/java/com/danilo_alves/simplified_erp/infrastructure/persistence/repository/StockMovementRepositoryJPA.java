package com.danilo_alves.simplified_erp.infrastructure.persistence.repository;

import com.danilo_alves.simplified_erp.infrastructure.persistence.entity.stock.StockMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockMovementRepositoryJPA extends JpaRepository<StockMovementEntity, String> {
}
