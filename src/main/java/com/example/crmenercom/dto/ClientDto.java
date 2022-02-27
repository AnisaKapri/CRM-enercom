package com.example.crmenercom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDto {
    private int id;
    private String name;
    private String status;
    private String nip;
    private LocalDateTime created;
    private boolean customerOfPCTI;
}
