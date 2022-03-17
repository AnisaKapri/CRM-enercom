package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.OperatorDto;
import com.example.crmenercom.entity.OperatorEntity;

public class OperatorMapper {

    public static OperatorEntity toEntity(OperatorDto dto) {
        if (dto == null) return null;
        OperatorEntity entity = new OperatorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static OperatorDto toDto(OperatorEntity entity) {
        if (entity == null) return null;
        OperatorDto dto = new OperatorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
