package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.NetworkOperatorDto;
import com.example.crmenercom.entity.NetworkOperatorEntity;

public class NetworkOperatorMapper {

    public static NetworkOperatorEntity toEntity(NetworkOperatorDto dto) {
        NetworkOperatorEntity entity = new NetworkOperatorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());
        return entity;
    }

    public static NetworkOperatorDto toDto(NetworkOperatorEntity entity) {
        NetworkOperatorDto dto = new NetworkOperatorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCountry(entity.getCountry());
        return dto;
    }
}
