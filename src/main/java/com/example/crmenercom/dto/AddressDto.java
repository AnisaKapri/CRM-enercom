package com.example.crmenercom.dto;

import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
public class AddressDto {

    private int id;
    private String country;
    private String city;
    private String street;
    private int postCode;
}
