package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.entity.ProductEntity;
import com.example.crmenercom.mapper.ProductMapper;
import com.example.crmenercom.repository.ProductRepository;
import com.example.crmenercom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
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
    public ProductDto findById(Integer id) {
        return repository.findById(id)
                .map(ProductMapper::toDto)
                .orElse(null);
    }

   @Override
    public Boolean isUnique(ProductDto newProduct){
        return selectAll().stream().noneMatch(product -> product.equalsLogically(newProduct));
    }



    @Override
    public List<ProductDto> selectAll() {
        return repository.findAll()
                .stream().map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductEntity create(ProductEntity product){
        return repository.save(product);
    }

  /* @Override
    public ProductDto add(ProductDto product) throws NonUniqueResultException {
        if (isUnique(product)) throw new NonUniqueResultException(product.getName());
        return ProductMapper.toDto(repository.save(ProductMapper.toEntity(product)));
    }

   */

    @Override
    public ProductDto delete(ProductDto product){
        repository.delete(ProductMapper.toEntity(product));
        return product;
    }

    @Override
    public ProductDto deleteById(Integer id){
        return delete(findById(id));
    }

    @Override
    public ProductDto update(ProductDto updated){
        return ProductMapper.toDto(repository.save(ProductMapper.toEntity(updated)));
    }

    @Override
    public ProductDto overwrite(ProductDto product){
        return ProductMapper.toDto(repository.save(ProductMapper.toEntity(product)));
    }
}
