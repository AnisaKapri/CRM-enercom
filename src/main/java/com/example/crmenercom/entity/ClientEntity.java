package com.example.crmenercom.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String country;
    private String company;
    private String operator;
    private String technologyDeployed;
    private String customerOfPCT;
    private String contact;
    private String role;
    private String contactedBy;
    private String phoneNumber;
    private String email;
    private String notes;
    private LocalDateTime created;


    @OneToMany(mappedBy = "client")
    private List<ProductEntity> products;




    //Lidh me nje tabele contactDetail??

}
