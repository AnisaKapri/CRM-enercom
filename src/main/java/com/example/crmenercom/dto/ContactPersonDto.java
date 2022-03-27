package com.example.crmenercom.dto;

import lombok.*;

@Getter
@Setter

public class ContactPersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
