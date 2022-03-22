package com.example.crmenercom.service;

import com.example.crmenercom.dto.OrderDto;
import com.example.crmenercom.dto.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderService {

    List<OrderDto> selectAll();

    List<OrderDto> selectAllFromUser(Integer customerId);

    OrderDto findById(Integer id);

    OrderDto add(Integer customerId, List<ProductDto> items);

    OrderDto add(OrderDto order);

    OrderDto update(OrderDto current, OrderDto updated);

    Boolean approveById(Integer id);

    OrderDto deleteById(Integer id);
}
