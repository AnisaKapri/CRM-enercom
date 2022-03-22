package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.ReportDto;
import com.example.crmenercom.entity.ReportEntity;
import com.example.crmenercom.mapper.ReportMapper;
import com.example.crmenercom.repository.ReportRepository;
import com.example.crmenercom.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class ReportServiceImpl implements ReportService {

    private final ReportRepository repository;

    @Override
    public ReportDto getById(int id) {
        return ReportMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public ReportDto create(ReportDto reportDto) {
        return ReportMapper.toDto(repository.save(ReportMapper.toEntity(reportDto)));
    }

    @Override
    public ReportDto update(ReportDto reportDto) {
        return ReportMapper.toDto(repository.save(ReportMapper.toEntity(reportDto)));
    }

    @Override
    public ReportDto deleteById(int id) {
        ReportEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return ReportMapper.toDto(entity);
    }
}
