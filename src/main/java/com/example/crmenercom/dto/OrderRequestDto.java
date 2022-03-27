package com.example.crmenercom.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OrderRequestDto {

    private Long customerId;
    private Map<Long, Boolean> productIds;

    public OrderRequestDto() {
    }

    public OrderRequestDto(List<ProductDto> products) {
        productIds = new HashMap<>();
        for (ProductDto product : products)
            productIds.put(product.getId(), false);
    }
}