package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.TechnologyDeployedDto;
import com.example.crmenercom.entity.TechnologyDeployedEntity;

public class TechnologyDeployedMapper {

    public static TechnologyDeployedEntity toEntity(TechnologyDeployedDto dto) {
        if (dto == null) return null;
        TechnologyDeployedEntity entity = new TechnologyDeployedEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setYears(dto.getYears());
        return entity;
    }

    public static TechnologyDeployedDto toDto(TechnologyDeployedEntity entity) {
        if (entity == null) return null;
        TechnologyDeployedDto dto = new TechnologyDeployedDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setYears(entity.getYears());
        return dto;
    }
}
