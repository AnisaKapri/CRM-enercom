package com.example.crmenercom.service;

import com.example.crmenercom.dto.SoldProductsDto;

import java.util.UUID;

public interface SoldProductsService {

    SoldProductsDto getById(int id);

    SoldProductsDto create(SoldProductsDto soldProductsDto);

    SoldProductsDto update(SoldProductsDto soldProductsDto);

    SoldProductsDto deleteById(int id);
}
