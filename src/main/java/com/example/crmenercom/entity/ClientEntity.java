package com.example.crmenercom.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String country;
    private String company;
    private String operator;
    private String technologyDeployed;
    private boolean customerOfPCT;
    private String contact;
    private String role;
    private String contactedBy;


    private LocalDateTime created;

    public boolean getCustomerOfPCT() {
        return false;
    }




    //Lidh me nje tabele contactDetail??

}
