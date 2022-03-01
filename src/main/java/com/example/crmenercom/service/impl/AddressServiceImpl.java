package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.AddressDto;
import com.example.crmenercom.mapper.AddressMapper;
import com.example.crmenercom.repository.AddressRepository;
import com.example.crmenercom.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {


    private final AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<AddressDto> selectAll() {
        return repository.findAll()
                .stream().map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(int id) {
        return repository.findById(id)
                .map(AddressMapper::toDto)
                .orElse(null);
    }


    @Override
    public AddressDto delete(AddressDto address) {
        repository.delete(AddressMapper.toEntity(address));
        return address;
    }

    @Override
    public AddressDto deleteById(int id) {
        return delete(findById(id));
    }



    /*
     private final ApplicationModuleRepository applicationModuleRepository;

    @Autowired
    public ApplicationModuleServiceImpl( ApplicationModuleRepository applicationModuleRepository){
        this.applicationModuleRepository = applicationModuleRepository;
    }


    @Override
    public ApplicationModule getApplicationModuleById(UUID id) {
        return applicationModuleRepository.findById(id).orElse(null);
    }

    @Override
    public ApplicationModule createApplicationModule(ApplicationModule applicationModule) {
        return applicationModuleRepository.save(applicationModule);
    }

    @Override
    public ApplicationModule updateApplicationModule(ApplicationModule applicationModule) {
        return applicationModuleRepository.save(applicationModule);
    }

    @Override
    public ApplicationModule deleteApplicationModuleById(UUID id) {
        ApplicationModule applicationModuleToBeDeleted = applicationModuleRepository.getById(id);
        applicationModuleRepository.deleteById(id);
        return applicationModuleToBeDeleted ;
    }
     */
}
