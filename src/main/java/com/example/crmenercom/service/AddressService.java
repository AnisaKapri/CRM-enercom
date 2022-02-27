package com.example.crmenercom.service;

import com.example.crmenercom.dto.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {

    List<AddressDto> selectAll();
    AddressDto findById(int id);
    AddressDto deleteById(int id);

}
