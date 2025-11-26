package com.danilo_alves.simplified_erp.infrastructure.mapper.stock;

import com.danilo_alves.simplified_erp.domain.entity.stock.StockMovementDomain;
import com.danilo_alves.simplified_erp.infrastructure.persistence.entity.stock.StockMovementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMovementMapper {

    @Mapping(source = "movementTypeDomain", target = "movementTypeEntity")
    StockMovementEntity toEntity(StockMovementDomain domain);

    @Mapping(source = "movementTypeEntity", target = "movementTypeDomain")
    StockMovementDomain toDomain(StockMovementEntity entity);
}

