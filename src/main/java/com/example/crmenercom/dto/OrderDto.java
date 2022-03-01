package com.example.crmenercom.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {

    private int id;
    private LocalDate date;
    private int customerId;
    private int status;
    private List<ProductDto> product;

    public OrderDto() {}

    public OrderDto(OrderDto o) {
        id = o.id;
        date = o.date;
        customerId = o.customerId;
        status = o.status;
        product = o.product;
    }

}
