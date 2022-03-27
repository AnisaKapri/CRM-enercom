package com.example.crmenercom.dto;

import com.example.crmenercom.entity.OrderEntity;
import com.example.crmenercom.util.Utils;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductDto {

    private Long id;
    @Pattern(regexp = Utils.MULT_NAMES_REGEX, message = "Product name is invalid!")
    private String name;
    private Integer status;
    private String price;
    private List<OrderEntity> orders = new ArrayList<>();

    public ProductDto() {
    }

    public ProductDto(ProductDto p) {
        id = p.id;
        name = p.name;
        status = p.status;
        price = p.price;
        orders = p.orders;
    }


    public void setName(String name) {
        this.name = Utils.capFirst(name);
    }

    public boolean equalsLogically(ProductDto product) {
        return this == product || name.equals(product.name);
    }
}
