package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.entity.CountryEntity;

public class CountryMapper {

    public static CountryEntity toEntity(CountryDto dto) {
        CountryEntity entity = new CountryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setNetworkOperators(dto.getNetworkOperators());
        return entity;
    }

    public static CountryDto toDto(CountryEntity entity) {
        CountryDto dto = new CountryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNetworkOperators(entity.getNetworkOperators());
        return dto;
    }
}
