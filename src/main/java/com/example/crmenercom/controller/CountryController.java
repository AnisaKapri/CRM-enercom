package com.example.crmenercom.controller;


import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.dto.UpdateDto;
import com.example.crmenercom.service.CountryService;
import com.example.crmenercom.service.ProductService;
import com.example.crmenercom.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/countries")

public class CountryController {

    private static final String
            CNT_LIST = "country/list";

    private final CountryService countryService;
    private final ProductService productService;


    public CountryController(CountryService countryService, ProductService productService) {
        this.countryService = countryService;
        this.productService = productService;
    }

    @GetMapping("/readCountry")
    public String getById(@ModelAttribute("country") CountryDto countryDto, BindingResult bindingResult, Model model) {
        countryService.getById(countryDto.getId());
        return "index";  // NDRYSHO
    }



    @DeleteMapping("/deleteCountry/{id}")
    public String deleteById(@PathVariable(value = "id") int id) {
        countryService.deleteById(id);
        return "index";
    }
}
