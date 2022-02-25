package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ContactedByDto;
import com.example.crmenercom.entity.ContactedByEntity;

public class ContactedByMapper {

    private static ContactedByEntity toEntity(ContactedByDto dto) {

        ContactedByEntity entity = new ContactedByEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    private static ContactedByDto toDto(ContactedByEntity entity) {

        ContactedByDto dto = new ContactedByDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
