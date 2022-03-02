package com.example.crmenercom.service;


import com.example.crmenercom.dto.SalesQuantityDto;

import java.util.UUID;

public interface SalesQuantityService {

    SalesQuantityDto getById(int id);

    SalesQuantityDto create(SalesQuantityDto salesQuantityDto);

    SalesQuantityDto update(SalesQuantityDto salesQuantityDto);

    SalesQuantityDto deleteById(int id);
}
