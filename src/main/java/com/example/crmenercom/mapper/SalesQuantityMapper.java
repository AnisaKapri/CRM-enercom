package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.SalesQuantityDto;
import com.example.crmenercom.entity.SalesQuantityEntity;

public class SalesQuantityMapper {

    public static SalesQuantityEntity toEntity(SalesQuantityDto dto) {
        if (dto == null) return null;
        SalesQuantityEntity entity = new SalesQuantityEntity();
        entity.setId(dto.getId());
        entity.setNumberOfSales(dto.getNumberOfSales());
        return entity;
    }

    public static SalesQuantityDto toDto(SalesQuantityEntity entity) {
        if (entity == null) return null;
        SalesQuantityDto dto = new SalesQuantityDto();
        dto.setId(entity.getId());
        dto.setNumberOfSales(entity.getNumberOfSales());
        return dto;
    }
}
