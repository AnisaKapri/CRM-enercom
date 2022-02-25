package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ContactPersonDto;
import com.example.crmenercom.entity.ContactPersonEntity;

public class ContactPersonMapper {

    public static ContactPersonEntity toEntity(ContactPersonDto dto) {
        ContactPersonEntity entity = new ContactPersonEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

    public static ContactPersonDto toDto(ContactPersonEntity entity) {
        ContactPersonDto dto = new ContactPersonDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        return dto;
    }
}
