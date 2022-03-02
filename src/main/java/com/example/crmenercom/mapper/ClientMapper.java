package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.entity.ClientEntity;

public class ClientMapper {

    public static ClientEntity toEntity(ClientDto dto){
        if (dto == null) return null;
        ClientEntity entity = new ClientEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        entity.setNip(dto.getNip());
        entity.setCreated(dto.getCreated());
        return entity;
    }

    public static ClientDto toDto(ClientEntity entity){
        if (entity == null) return null;
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setNip(entity.getNip());
        dto.setCreated(entity.getCreated());
        return dto;
    }

}
