package com.example.crmenercom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private int customerId;
    private int status;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = {
                    @JoinColumn(name = "order_id") },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id") }
    )

    private List<ProductEntity> product;

    public OrderEntity(int id, LocalDate date, int customerId, int status, List<ProductEntity> product) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.status = status;
        this.product = product;
    }

    public OrderEntity() {
    }
}
