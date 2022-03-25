package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.entity.CountryEntity;

public class CountryMapper {

    public static CountryEntity toEntity(CountryDto dto) {
        if (dto == null) return null;
        CountryEntity entity = new CountryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setNetworkOperator(dto.getNetworkOperator());
        return entity;
    }

    public static CountryDto toDto(CountryEntity entity) {
        if (entity == null) return null;
        CountryDto dto = new CountryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNetworkOperator(entity.getNetworkOperator());
        return dto;
    }
}
