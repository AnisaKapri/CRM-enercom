package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.CompanyDto;
import com.example.crmenercom.entity.CompanyEntity;

public class CompanyMapper {

    public static CompanyEntity toEntity(CompanyDto dto){
        CompanyEntity entity =  new CompanyEntity();
        entity.setId(dto.getId());
        entity.setFullName(dto.getFullName());
        entity.setNip(dto.getNip());
        return entity;
    }

    public static CompanyDto toDto(CompanyEntity entity){
        CompanyDto dto =  new CompanyDto();
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setNip(entity.getNip());
        return dto;
    }
}
