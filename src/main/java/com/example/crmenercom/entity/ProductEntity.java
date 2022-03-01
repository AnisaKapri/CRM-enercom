package com.example.crmenercom.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String price;

    @ManyToMany(mappedBy = "product")
    private List<OrderEntity> order;


    public ProductEntity() {
    }

    public ProductEntity(int id, String name, String price, List<OrderEntity> order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.order = order;
    }
}
