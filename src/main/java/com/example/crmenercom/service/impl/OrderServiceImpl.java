package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.OrderDto;
import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.entity.OrderEntity;
import com.example.crmenercom.mapper.OrderMapper;
import com.example.crmenercom.mapper.ProductMapper;
import com.example.crmenercom.repository.OrderRepository;
import com.example.crmenercom.service.OrderService;
import com.example.crmenercom.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderDto> selectAll() {
        return repository.findAll()
                .stream().map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> selectAllFromUser(Long id) {
        return repository.findAll()
                .stream().map(OrderMapper::toDto)
                .filter(order -> order.getCustomerId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Long id) {
        return repository.findById(id)
                .map(OrderMapper::toDto)
                .orElse(null);
    }

    @Override
    public OrderDto add(Long customerId, List<ProductDto> products) {
        OrderEntity entity = new OrderEntity();
        entity.setDate(LocalDate.now());
        entity.setCustomerId(customerId);
        entity.setStatus(OrderStatus.PENDING.code());
        entity.setProducts(products.stream()
                .map(ProductMapper::toEntity)
                .collect(Collectors.toList()));
        return OrderMapper.toDto(repository.save(entity));
    }

    @Override
    public OrderDto add(OrderDto orders) {
        return add(orders.getCustomerId(), orders.getProducts());
    }

    @Override
    public OrderDto update(OrderDto current, OrderDto updated) {
        repository.save(OrderMapper.toEntity(updated));
        return current;
    }

    @Override
    public Boolean approveById(Long id) {
        OrderDto order = findById(id);
        if (order != null && Objects.equals(order.getStatus(), OrderStatus.PENDING.code())) {
            OrderDto updated = new OrderDto(order);
            updated.setStatus(OrderStatus.APPROVED.code());
            update(order, updated);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public OrderDto deleteById(Long id) {
        OrderEntity order = repository.findById(id).orElse(null);
        if (order != null) {
            OrderDto dto = OrderMapper.toDto(order);
            repository.delete(order);
            return dto;
        } else {
            return null;
        }
    }
}
