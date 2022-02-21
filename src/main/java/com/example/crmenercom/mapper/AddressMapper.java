package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.AddressDto;
import com.example.crmenercom.entity.Address;

public interface AddressMapper {

    Address toEntity(AddressDto dto);
    AddressDto toDto(Address entity);
}
