package com.example.crmenercom.controller;


import com.example.crmenercom.dto.ContactPersonDto;
import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountryController {

    private final CountryService countryService;


    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/readCountry")
    public String getById(@ModelAttribute("country") CountryDto countryDto, BindingResult bindingResult, Model model){
        countryService.getById(countryDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveCountry")
    public String create(@ModelAttribute("country") CountryDto countryDto, BindingResult bindingResult, Model model){
        countryService.create(countryDto);
        return "index";
    }

    @PutMapping("/updateCountry")
    public String update(@ModelAttribute("country") CountryDto countryDto, BindingResult bindingResult, Model model){
        countryService.update(countryDto);
        return "index";
    }

    @DeleteMapping("/deleteCountry/{id}")
    public String deleteById(@PathVariable (value = "id") int id){
        countryService.deleteById(id);
        return "index";
    }
}
