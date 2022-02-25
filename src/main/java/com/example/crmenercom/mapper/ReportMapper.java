package com.example.crmenercom.mapper;

import com.example.crmenercom.dto.ReportDto;
import com.example.crmenercom.entity.ReportEntity;

public class ReportMapper {

    public static ReportEntity toEntity(ReportDto dto) {
        ReportEntity entity = new ReportEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setFileName(dto.getFileName());
        entity.setCreated(dto.getCreated());
        return entity;
    }

    public static ReportDto toDto(ReportEntity entity) {
        ReportDto dto = new ReportDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setFileName(entity.getFileName());
        dto.setCreated(entity.getCreated());
        return dto;
    }
}
