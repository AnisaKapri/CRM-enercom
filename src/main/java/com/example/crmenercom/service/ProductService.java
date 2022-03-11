package com.example.crmenercom.service;

import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.entity.ProductEntity;
import org.hibernate.NonUniqueObjectException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductService {
    Boolean contains(ProductDto product);

    List<ProductDto> selectAll();

    ProductDto findById(Integer id);

    Boolean isUnique(ProductDto product);

    ProductEntity create(ProductEntity product);

    ProductDto update(ProductDto current, ProductDto updated);

    ProductDto overwrite(ProductDto product);

    ProductDto delete(ProductDto product);

    ProductDto deleteById(Integer id);

    Boolean approveById(Integer id);


    void update(ProductDto updated); //KONTROLLOJE SE ESHTE GABIM
}
