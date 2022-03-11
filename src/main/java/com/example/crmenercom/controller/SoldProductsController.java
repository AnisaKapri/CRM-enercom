package com.example.crmenercom.controller;

import com.example.crmenercom.dto.SalesQuantityDto;
import com.example.crmenercom.dto.SoldProductsDto;
import com.example.crmenercom.service.SoldProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SoldProductsController {

    private final SoldProductsService soldProductsService;


    public SoldProductsController(SoldProductsService soldProductsService) {
        this.soldProductsService = soldProductsService;
    }

    @GetMapping("/read")
    public String getById(@ModelAttribute("soldProducts") SoldProductsDto soldProductsDto, BindingResult bindingResult, Model model){
        soldProductsService.getById(soldProductsDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("soldProducts") SoldProductsDto soldProductsDto, BindingResult bindingResult, Model model){
        soldProductsService.create(soldProductsDto);
        return "index";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("soldProducts") SoldProductsDto soldProductsDto, BindingResult bindingResult, Model model){
        soldProductsService.update(soldProductsDto);
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable (value = "id") int id){
        soldProductsService.deleteById(id);
        return "index";
    }
}
