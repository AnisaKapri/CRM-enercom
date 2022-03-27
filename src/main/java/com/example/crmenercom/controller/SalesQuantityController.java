package com.example.crmenercom.controller;

import com.example.crmenercom.dto.SalesQuantityDto;
import com.example.crmenercom.service.SalesQuantityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SalesQuantityController {

    private final SalesQuantityService salesQuantityService;


    public SalesQuantityController(SalesQuantityService salesQuantityService) {
        this.salesQuantityService = salesQuantityService;
    }

    @GetMapping("/readSalesQuantity")
    public String getById(@ModelAttribute("salesQuantity") SalesQuantityDto salesQuantityDto, BindingResult bindingResult, Model model){
        salesQuantityService.getById(salesQuantityDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveSalesQuantity")
    public String create(@ModelAttribute("salesQuantity") SalesQuantityDto salesQuantityDto, BindingResult bindingResult, Model model){
        salesQuantityService.create(salesQuantityDto);
        return "index";
    }

    @PutMapping("/updateSalesQuantity")
    public String update(@ModelAttribute("salesQuantity") SalesQuantityDto salesQuantityDto, BindingResult bindingResult, Model model){
        salesQuantityService.update(salesQuantityDto);
        return "index";
    }

    @DeleteMapping("/deleteSalesQuantity/{id}")
    public String deleteById(@PathVariable (value = "id") Long id){
        salesQuantityService.deleteById(id);
        return "index";
    }
}
