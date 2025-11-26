package com.danilo_alves.simplified_erp.domain.entity.stock;

import com.danilo_alves.simplified_erp.domain.entity.product.ProductDomain;
import com.danilo_alves.simplified_erp.domain.entity.stock.enums.MovementDomain;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockMovementDomain {
    private Long id;
    private ProductDomain product;
    private Integer quantityChanged;
    private OffsetDateTime timeStamp;
    private UserDomain changedBy;
    private MovementDomain movementTypeDomain;

}
