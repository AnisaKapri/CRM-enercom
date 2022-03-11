package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.CompanyDto;
import com.example.crmenercom.entity.CompanyEntity;

public class CompanyMapper {

    public static CompanyEntity toEntity(CompanyDto dto) {
        if (dto == null) return null;
        CompanyEntity entity = new CompanyEntity();
        entity.setId(dto.getId());
        entity.setFullName(dto.getFullName());

        return entity;
    }

    public static CompanyDto toDto(CompanyEntity entity) {
        if (entity == null) return null;
        CompanyDto dto = new CompanyDto();
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());

        return dto;
    }
}
