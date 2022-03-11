package com.example.crmenercom.dto;

import com.example.crmenercom.entity.OrderEntity;
import com.example.crmenercom.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class ProductDto {

    private Integer id;
    @Pattern(regexp = Utils.MULT_NAMES_REGEX, message = "Product name is invalid!")
    private String name;
    private int status;
    private String price;
    private List<OrderEntity> order = new ArrayList<>();


    public ProductDto(Integer id, String name, int status, String price, List<OrderEntity> order) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.price = price;
        this.order = order;
    }

    public ProductDto(ProductDto product) {
    }


    public void setName(String name) {
        this.name = Utils.capFirst(name);
    }


    public boolean equalsLogically(ProductDto product) {
        return this == product || name.equals(product.name);
    }
}
