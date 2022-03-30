package com.example.crmenercom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer status;
    private String price;

    @ManyToMany(mappedBy = "products")
    private List<OrderEntity> orders;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;


}
