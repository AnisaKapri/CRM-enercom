package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.entity.ClientEntity;

public class ClientMapper {

    public static ClientEntity toEntity(ClientDto dto) {
        ClientEntity entity = new ClientEntity();
        entity.setId(dto.getId());
        entity.setCountry(dto.getCountry());
        entity.setCompany(dto.getCompany());
        entity.setOperator(dto.getOperator());
        entity.setTechnologyDeployed(dto.getTechnologyDeployed());
        entity.setCustomerOfPCT(dto.getCustomerOfPCT());
        entity.setContact(dto.getContact());
        entity.setRole(dto.getRole());
        entity.setContactedBy(dto.getContactedBy());
        entity.setCreated(dto.getCreated());
        entity.setProducts(dto.getProducts());
        return entity;
    }

    public static ClientDto toDto(ClientEntity entity) {
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setCountry(entity.getCountry());
        dto.setCompany(entity.getCompany());
        dto.setOperator(entity.getOperator());
        dto.setTechnologyDeployed(entity.getTechnologyDeployed());
        dto.setContact(entity.getContact());
        dto.setCustomerOfPCT(entity.getCustomerOfPCT());
        dto.setRole(entity.getRole());
        dto.setContactedBy(entity.getContactedBy());
        dto.setCreated(entity.getCreated());
        dto.setProducts(entity.getProducts());
        return dto;
    }
}
