package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.entity.ProductEntity;
import com.example.crmenercom.mapper.ClientMapper;
import com.example.crmenercom.mapper.ProductMapper;
import com.example.crmenercom.repository.ProductRepository;
import com.example.crmenercom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean contains(ProductDto product) {
        return selectAll().contains(product);
    }

    @Override
    public Boolean contains(ClientDto client){
        return selectAll().stream().anyMatch(product ->
              client.getCompany().equals(product.getClient()));
    }


 /*   @Override
    public Long getNumOfProducts(ClientDto client){
        return selectAll().stream().map(ProductDto::getClient)
                .filter(client::equals)
                .count();
    }

  */


    @Override
    public ProductDto findById(Long id) {
        return repository.findById(id)
                .map(ProductMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ProductDto> selectAll() {
        return repository.findAll()
                .stream().map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto add(ProductDto product) throws NonUniqueResultException {
        if (isUnique(product))
            throw new NonUniqueResultException(product.getName());
        return ProductMapper.toDto(repository.save(ProductMapper.toEntity(product)));
    }

    @Override
    public Boolean isUnique(ProductDto newProduct) {
        return selectAll().stream().noneMatch(product ->
                product.equalsLogically(newProduct));
    }

    @Override
    public ProductDto overwrite(ProductDto product) {
        return ProductMapper.toDto(repository.save(ProductMapper.toEntity(product)));
    }


    @Override
    public ProductDto update(ProductDto updated) {

        if (updated.getId() == null)
            throw new IllegalArgumentException("Id must be supplied on update");
        ProductEntity existing = repository.findById(updated.getId()).orElse(null);
        if (existing == null)
            throw new EntityNotFoundException("Product with this id cannot be found");
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setStatus(updated.getStatus());

        return ProductMapper.toDto(repository.save(existing));
    }

    @Override
    public List<ProductDto> selectAllByClient(String client) {
        return repository.findAllByClientCompany(client)
                .stream().map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto updateClient(ClientDto current, ClientDto updated) {
        if (contains(current)) {
            for (ProductDto product : selectAll()){
                if (current.equals(product.getClient())){
                    product.setClient(ClientMapper.toEntity(updated));
                    overwrite(product);
                }
            }
            return updated;
        }
        return null;
    }

    @Override
    public ProductDto delete(ProductDto product) {
        repository.delete(ProductMapper.toEntity(product));
        return product;
    }

    @Override
    public ProductDto deleteById(Long id) {
        ProductEntity product = repository.findById(id).orElse(null);
        if (product != null) {
            ProductDto dto = ProductMapper.toDto(product);
            repository.delete(product);
            return dto;
        } else {
            return null;

        }

    }


}
