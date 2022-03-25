package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.NetworkOperatorDto;
import com.example.crmenercom.entity.NetworkOperatorEntity;

public class NetworkOperatorMapper {

    public static NetworkOperatorEntity toEntity(NetworkOperatorDto dto) {
        if (dto == null) return null;
        NetworkOperatorEntity entity = new NetworkOperatorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static NetworkOperatorDto toDto(NetworkOperatorEntity entity) {
        if (entity == null) return null;
        NetworkOperatorDto dto = new NetworkOperatorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
