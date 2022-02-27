package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.OrderDto;
import com.example.crmenercom.entity.OrderEntity;

import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderEntity toEntity(OrderDto dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setCustomerId(dto.getCustomerId());
        entity.setStatus(dto.getStatus());
        entity.setProducts(dto.getProducts()
                .stream().map(ProductMapper::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }

    public static OrderDto toDto(OrderEntity entity) {
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setCustomerId(entity.getCustomerId());
        dto.setStatus(entity.getStatus());
        dto.setProducts(entity.getProducts()
                .stream().map(ProductMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
