package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.AddressDto;
import com.example.crmenercom.entity.AddressEntity;

public class AddressMapper {

    public static AddressEntity toEntity(AddressDto dto) {
        if (dto == null) return null;
        AddressEntity entity = new AddressEntity();
        entity.setId(dto.getId());
        entity.setCountry(dto.getCountry());
        entity.setCity(dto.getCity());
        entity.setStreet(dto.getStreet());
        entity.setPostCode(dto.getPostCode());
        return entity;
    }

    public static AddressDto toDto(AddressEntity entity) {
        if (entity == null) return null;
        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setCountry(entity.getCountry());
        dto.setCity(entity.getCountry());
        dto.setStreet(entity.getStreet());
        dto.setPostCode(entity.getPostCode());
        return dto;
    }
}
