package com.danilo_alves.marketplace_inventory.infrastructure.mapper.product;

import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.infrastructure.persistence.entity.product.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductDomain productDomain);

    ProductDomain toDomain(ProductEntity productEntity);

}