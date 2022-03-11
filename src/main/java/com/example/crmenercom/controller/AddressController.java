package com.example.crmenercom.controller;

import com.example.crmenercom.dto.AddressDto;
import com.example.crmenercom.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/readAddress")
    public String getById(@ModelAttribute("address") AddressDto addressDto, BindingResult bindingResult, Model model){
        addressService.getById(addressDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveAddress")
    public String create(@ModelAttribute("address") AddressDto addressDto, BindingResult bindingResult, Model model){
        addressService.create(addressDto);
        return "index";
    }

    @PutMapping("/updateAddress")
    public String update(@ModelAttribute("address") AddressDto addressDto, BindingResult bindingResult, Model model){
        addressService.update(addressDto);
        return "index";
    }

    @DeleteMapping("/deleteAddress/{id}")
    public String deleteById(@PathVariable (value = "id") int id){
        addressService.deleteById(id);
        return "index";
    }

}


