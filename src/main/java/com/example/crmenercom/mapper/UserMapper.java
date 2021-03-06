package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserDto dto) {
        if (dto == null) return null;
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setRole(dto.getRole());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public static UserDto toDto(UserEntity entity) {
        if (entity == null) return null;
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setRole(entity.getRole());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        return dto;
    }
}
