package com.example.crmenercom.dto;

import com.example.crmenercom.entity.ClientEntity;
import com.example.crmenercom.entity.CountryEntity;
import com.example.crmenercom.entity.OrderEntity;
import com.example.crmenercom.util.Utils;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class ProductDto {

    private Long id;
    @Pattern(regexp = Utils.MULT_NAMES_REGEX, message = "Product name is invalid!")
    private String name;
    private Integer status;
    private String price;
    private List<OrderEntity> orders = new ArrayList<>();
    private ClientEntity client;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, Integer status, String price, List<OrderEntity> orders, ClientEntity client) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.price = price;
        this.orders = orders;
        this.client = client;
    }

    public void setName(String name) {
        this.name = Utils.capFirst(name);
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id.equals(that.id)
                && Objects.equals(client, that.client);
    }

    public boolean equalsLogically(ProductDto product) {
        return this == product || name.equals(product.name);
    }
}
