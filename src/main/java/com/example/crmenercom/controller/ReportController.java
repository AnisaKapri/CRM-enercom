package com.example.crmenercom.controller;


import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.dto.ReportDto;
import com.example.crmenercom.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReportController {

    private final ReportService reportService;


    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/readReport")
    public String getById(@ModelAttribute("report") ReportDto reportDto, BindingResult bindingResult, Model model){
        reportService.getById(reportDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveReport")
    public String create(@ModelAttribute("report") ReportDto reportDto, BindingResult bindingResult, Model model){
        reportService.create(reportDto);
        return "index";
    }

    @PutMapping("/updateReport")
    public String update(@ModelAttribute("report") ReportDto reportDto, BindingResult bindingResult, Model model){
        reportService.update(reportDto);
        return "index";
    }

    @DeleteMapping("/deleteReport/{id}")
    public String deleteById(@PathVariable (value = "id") Long id){
        reportService.deleteById(id);
        return "index";
    }
}
