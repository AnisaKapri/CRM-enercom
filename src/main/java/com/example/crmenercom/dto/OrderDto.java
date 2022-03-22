package com.example.crmenercom.dto;

import com.example.crmenercom.util.Utils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private int id;
    private LocalDate date;
    private Integer customerId;
    private Integer status;
    private List<ProductDto> products;

    public OrderDto() {}

    public OrderDto(OrderDto o) {
        id = o.id;
        date = o.date;
        customerId = o.customerId;
        status = o.status;
        products = o.products;
    }

    public String getLongDate() {
        return Utils.convertToLongDate(date);
    }

}
