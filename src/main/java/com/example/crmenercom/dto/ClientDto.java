package com.example.crmenercom.dto;

import com.example.crmenercom.entity.ProductEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    private String title;
    private String contactedBy;
    private String phoneNumber;
    private String email;
    private String notes;
    private List<ProductEntity> products;
    private LocalDateTime created;

    public ClientDto(String company) {
        this.company = company;
    }


}
