package com.example.crmenercom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {

    private int id;
    private LocalDate date;
    private int customerId;
    private int status;
    private List<ProductDto> products;

    public OrderDto() {}

    public OrderDto(OrderDto o) {
        id = o.id;
        date = o.date;
        customerId = o.customerId;
        status = o.status;
        products = o.products;
    }

}
