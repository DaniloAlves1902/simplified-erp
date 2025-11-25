package com.danilo_alves.marketplace_inventory.domain.entity.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDomain {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

}
