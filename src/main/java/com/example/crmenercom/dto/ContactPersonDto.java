package com.example.crmenercom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactPersonDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
