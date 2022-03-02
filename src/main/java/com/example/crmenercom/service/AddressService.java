package com.example.crmenercom.service;

import com.example.crmenercom.dto.AddressDto;
import java.util.UUID;

public interface AddressService {

    AddressDto getById(int id);

    AddressDto create(AddressDto addressDto);


    AddressDto update(AddressDto addressDto);


    AddressDto deleteById(int id);

}
