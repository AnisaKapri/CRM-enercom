package com.example.crmenercom.service;

import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.entity.ProductEntity;
import org.hibernate.NonUniqueObjectException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NonUniqueResultException;
import java.util.List;

@Transactional
public interface ProductService {

    Boolean contains(ProductDto product);

    List<ProductDto> selectAll();

    ProductDto findById(Long id);

    Boolean isUnique(ProductDto product);

    ProductDto add(ProductDto product) throws NonUniqueResultException;

    ProductDto delete(ProductDto product);

    ProductDto deleteById(Long id);

    ProductDto overwrite(ProductDto product);

    ProductDto update(ProductDto updated);
}
