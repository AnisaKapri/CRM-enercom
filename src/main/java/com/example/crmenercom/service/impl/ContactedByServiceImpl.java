package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.ContactedByDto;
import com.example.crmenercom.entity.ContactedByEntity;
import com.example.crmenercom.mapper.ContactedByMapper;
import com.example.crmenercom.repository.ContactedByRepository;
import com.example.crmenercom.service.ContactedByService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class ContactedByServiceImpl implements ContactedByService {

    private final ContactedByRepository repository;

    @Override
    public ContactedByDto getById(int id) {
        return ContactedByMapper.toDto(repository.findById(id).orElse(null));

    }

    @Override
    public ContactedByDto create(ContactedByDto contactedByDto) {
        return ContactedByMapper.toDto(repository.save(ContactedByMapper.toEntity(contactedByDto)));
    }

    @Override
    public ContactedByDto update(ContactedByDto contactedByDto) {
        return ContactedByMapper.toDto(repository.save(ContactedByMapper.toEntity(contactedByDto)));
    }

    @Override
    public ContactedByDto deleteById(int id) {
        ContactedByEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return ContactedByMapper.toDto(entity);
    }
}
