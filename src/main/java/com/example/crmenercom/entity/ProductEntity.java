package com.example.crmenercom.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder

@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String price;

    @ManyToMany(mappedBy = "products")
    private List<OrderEntity> orders;


    public ProductEntity() {
    }

    public ProductEntity(int id, String name, String price, List<OrderEntity> orders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orders = orders;
    }
}
