package com.example.crmenercom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int id;
    private LocalDate date;
    private int customerId;
    private int status;
    private List<ProductDto> products;
}
