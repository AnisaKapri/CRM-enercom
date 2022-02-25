package com.example.crmenercom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private int id;
    private String title;
    private String fileName;
    private LocalDate created;
}
