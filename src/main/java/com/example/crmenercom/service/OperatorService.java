package com.example.crmenercom.service;
import com.example.crmenercom.dto.OperatorDto;

public interface OperatorService {

    OperatorDto getById(int id);

    OperatorDto create(OperatorDto operatorDto);


    OperatorDto update(OperatorDto operatorDto);


    OperatorDto deleteById(int id);
}
