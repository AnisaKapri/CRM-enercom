package com.example.crmenercom.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter

public class ReportDto {
    private Long id;
    private String title;
    private String fileName;
    private LocalDate created;
}
