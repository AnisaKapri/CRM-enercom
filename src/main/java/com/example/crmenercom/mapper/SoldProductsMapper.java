package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.SoldProductsDto;
import com.example.crmenercom.entity.SoldProductsEntity;

public class SoldProductsMapper {

    public static SoldProductsEntity toEntity(SoldProductsDto dto){
        if(dto == null) return null;
        SoldProductsEntity entity = new SoldProductsEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static SoldProductsDto toDto(SoldProductsEntity entity){
        if (entity == null) return null;
        SoldProductsDto dto = new SoldProductsDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
