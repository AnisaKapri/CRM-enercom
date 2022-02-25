package com.example.crmenercom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
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

    private List<ProductEntity> products;



}
