package com.example.crmenercom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales_quantity")
public class SalesQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberOfSales;

}
