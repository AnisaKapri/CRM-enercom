package com.example.crmenercom.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String country;
    private String company;
    private String operator;
    private String technologyDeployed;
    private String customerOfPCT;
    private String contact;
    private String role;
    private String contactedBy;

    private LocalDateTime created;

    public ClientDto(String company) {
        this.company = company;
    }


}
