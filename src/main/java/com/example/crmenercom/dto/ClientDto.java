package com.example.crmenercom.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClientDto {
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


}
