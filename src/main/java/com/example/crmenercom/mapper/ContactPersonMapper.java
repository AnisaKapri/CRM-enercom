package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ContactPersonDto;
import com.example.crmenercom.entity.ContactPersonEntity;

public class ContactPersonMapper {

    public static ContactPersonEntity toEntity(ContactPersonDto dto) {
        if (dto == null) return null;
        ContactPersonEntity entity = new ContactPersonEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

    public static ContactPersonDto toDto(ContactPersonEntity entity) {
        if (entity == null) return null;
        ContactPersonDto dto = new ContactPersonDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        return dto;
    }
}
