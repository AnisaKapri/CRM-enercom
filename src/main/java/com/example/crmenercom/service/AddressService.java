package com.example.crmenercom.service;

import com.example.crmenercom.dto.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    List<AddressDto> selectAll();
    AddressDto findById(int id);

    AddressDto delete(AddressDto address);

    AddressDto deleteById(int id);


  /*  ApplicationModule getApplicationModuleById(UUID id);

    ApplicationModule createApplicationModule(ApplicationModule applicationModule);


    ApplicationModule updateApplicationModule(ApplicationModule applicationModule);


    ApplicationModule deleteApplicationModuleById(UUID id);

   */

}
