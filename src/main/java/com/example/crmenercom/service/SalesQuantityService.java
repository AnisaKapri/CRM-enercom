package com.example.crmenercom.service;


import com.example.crmenercom.dto.SalesQuantityDto;

import java.util.UUID;

public interface SalesQuantityService {

    SalesQuantityDto getById(Long id);

    SalesQuantityDto create(SalesQuantityDto salesQuantityDto);

    SalesQuantityDto update(SalesQuantityDto salesQuantityDto);

    SalesQuantityDto deleteById(Long id);
}
