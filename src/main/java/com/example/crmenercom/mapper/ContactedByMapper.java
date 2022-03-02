package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ContactedByDto;
import com.example.crmenercom.entity.ContactedByEntity;

public class ContactedByMapper {

    public static ContactedByEntity toEntity(ContactedByDto dto) {
        if (dto == null) return null;
        ContactedByEntity entity = new ContactedByEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static ContactedByDto toDto(ContactedByEntity entity) {
        if (entity == null) return null;
        ContactedByDto dto = new ContactedByDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
