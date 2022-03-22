package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.ContactPersonDto;
import com.example.crmenercom.entity.ContactPersonEntity;
import com.example.crmenercom.mapper.ContactPersonMapper;
import com.example.crmenercom.repository.ContactPersonRepository;
import com.example.crmenercom.service.ContactPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class ContactPersonServiceImpl implements ContactPersonService {

    private final ContactPersonRepository repository;

    @Override
    public ContactPersonDto getById(int id) {
        return ContactPersonMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public ContactPersonDto create(ContactPersonDto contactPersonDto) {
        return ContactPersonMapper.toDto(repository.save(ContactPersonMapper.toEntity(contactPersonDto)));
    }

    @Override
    public ContactPersonDto update(ContactPersonDto contactPersonDto) {
        return ContactPersonMapper.toDto(repository.save(ContactPersonMapper.toEntity(contactPersonDto)));
    }

    @Override
    public ContactPersonDto deleteById(int id) {
        ContactPersonEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return ContactPersonMapper.toDto(entity);
    }
}
