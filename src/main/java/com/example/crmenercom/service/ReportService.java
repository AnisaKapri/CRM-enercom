package com.example.crmenercom.service;

import com.example.crmenercom.dto.ReportDto;

import java.util.UUID;

public interface ReportService {
    ReportDto getById(int id);

    ReportDto create(ReportDto reportDto);


    ReportDto update(ReportDto reportDto);


    ReportDto deleteById(int id);
}
