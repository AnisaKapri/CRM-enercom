package com.example.crmenercom.service;

import com.example.crmenercom.dto.ProductDto;
import org.hibernate.NonUniqueObjectException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    Boolean contains(ProductDto product);

    List<ProductDto> selectAll();

    ProductDto findById(int id);

    Boolean isUnique(ProductDto product);

    ProductDto add(ProductDto product) throws NonUniqueObjectException;

    ProductDto overwrite(ProductDto product);

    ProductDto delete(ProductDto product);

    ProductDto deleteById(ProductDto id);

    ProductDto update(ProductDto updated);

}
