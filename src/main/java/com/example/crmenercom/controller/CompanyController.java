package com.example.crmenercom.controller;

import com.example.crmenercom.dto.CompanyDto;
import com.example.crmenercom.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {

    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/readCompany")
    public String getById(@ModelAttribute("company") CompanyDto companyDto, BindingResult bindingResult, Model model){
        companyService.getById(companyDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveCompany")
    public String create(@ModelAttribute("company") CompanyDto companyDto, BindingResult bindingResult, Model model){
        companyService.create(companyDto);
        return "index";
    }

    @PutMapping("/updateCompany")
    public String update(@ModelAttribute("company") CompanyDto companyDto, BindingResult bindingResult, Model model){
        companyService.update(companyDto);
        return "index";
    }

    @DeleteMapping("/deleteCompany/{id}")
    public String deleteById(@PathVariable (value = "id") Long id){
        companyService.deleteById(id);
        return "index";
    }

}
