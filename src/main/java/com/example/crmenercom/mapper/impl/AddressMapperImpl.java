package com.example.crmenercom.mapper.impl;

import com.example.crmenercom.dto.AddressDto;
import com.example.crmenercom.entity.Address;
import com.example.crmenercom.mapper.AddressMapper;

public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toEntity(AddressDto dto) {
        if (dto == null) return null;
        Address entity = new Address();
        entity.setId(dto.getId());
        entity.setCountry(dto.getCountry());
        entity.setCity(dto.getCity());
        entity.setStreet(dto.getStreet());
        entity.setPostCode(dto.getPostCode());
        return entity;
    }

    @Override
    public AddressDto toDto(Address entity) {
        return null;
    }
}
