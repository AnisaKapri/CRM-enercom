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

    @GetMapping("/read")
    public String getById(@ModelAttribute("company") CompanyDto companyDto, BindingResult bindingResult, Model model){
        companyService.getById(companyDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("company") CompanyDto companyDto, BindingResult bindingResult, Model model){
        companyService.create(companyDto);
        return "index";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("company") CompanyDto companyDto, BindingResult bindingResult, Model model){
        companyService.update(companyDto);
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable (value = "id") int id){
        companyService.deleteById(id);
        return "index";
    }

}
