package com.example.crmenercom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDto {
    private int id;
    private String fullName;
    private String nip;
}
