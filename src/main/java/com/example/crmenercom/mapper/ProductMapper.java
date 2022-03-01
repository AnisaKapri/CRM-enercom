package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(ProductDto dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setOrder(dto.getOrder());
        return entity;
    }

    public static ProductDto toDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setOrder(entity.getOrder());
        return dto;
    }

}
