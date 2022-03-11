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

    @GetMapping("/read")
    public String getById(@ModelAttribute("report") ReportDto reportDto, BindingResult bindingResult, Model model){
        reportService.getById(reportDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("report") ReportDto reportDto, BindingResult bindingResult, Model model){
        reportService.create(reportDto);
        return "index";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("report") ReportDto reportDto, BindingResult bindingResult, Model model){
        reportService.update(reportDto);
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable (value = "id") int id){
        reportService.deleteById(id);
        return "index";
    }
}
