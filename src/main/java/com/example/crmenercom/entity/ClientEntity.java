package com.example.crmenercom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
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

    public boolean getCustmerOfPCT() {
        return false;
    }


    //Lidh me nje tabele contactDetail??

}
