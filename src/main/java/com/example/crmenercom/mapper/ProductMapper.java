package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(ProductDto dto) {
        if (dto == null) return null;
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setQuantityOnStock(dto.getQuantityOnStock());
        entity.setQuantityOnProduction(dto.getQuantityOnProduction());
        entity.setStatus(dto.getStatus());

        entity.setOrders(dto.getOrders());
        entity.setClient(dto.getClient());
        return entity;
    }

    public static ProductDto toDto(ProductEntity entity) {
        if (entity == null) return null;
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setQuantityOnStock(entity.getQuantityOnStock());
        dto.setQuantityOnProduction(entity.getQuantityOnProduction());
        dto.setStatus(entity.getStatus());
        dto.setOrders(entity.getOrders());
        dto.setClient(entity.getClient());
        return dto;
    }

}
