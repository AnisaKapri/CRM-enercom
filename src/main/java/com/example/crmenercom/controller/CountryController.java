package com.example.crmenercom.controller;


import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.dto.NetworkOperatorDto;
import com.example.crmenercom.service.CountryService;
import com.example.crmenercom.service.NetworkOperatorService;
import com.example.crmenercom.service.UserService;
import com.example.crmenercom.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryController {

    private static final String
            COUNTRY_LIST = "country/list",
            COUNTRY_BY_ID = "country/id",
            RESULT = "country/result",
            ERROR = "error";

    private final AuthController auth;
    private final CountryService countryService;
    private final NetworkOperatorService networkOperatorService;
    private final UserService userService;


    @Autowired
    public CountryController(AuthController auth, CountryService countryService, NetworkOperatorService networkOperatorService, UserService userService) {
        this.auth = auth;
        this.countryService = countryService;
        this.networkOperatorService = networkOperatorService;
        this.userService = userService;
    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }

    @GetMapping({"/", ""})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<CountryDto> countries = countryService.selectAll();
        List<NetworkOperatorDto> networkOperators = networkOperatorService.selectAll();
        model.addAttribute("countries", countries);
        model.addAttribute("networkOperators", networkOperators);
        model.addAttribute("updateCountries", new CountryDto());
        return COUNTRY_LIST;
    }


    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable(value = "id") int id) {
        CountryDto country = countryService.findById(id);
        if (country == null) {
            model.addAttribute("error", Utils.COUNTRY_NOT_FOUND);
            return ERROR;
        } else {
            addLoggedInUser(model);
            // getCountryData(model, country);
            return COUNTRY_BY_ID;
        }
    }


    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateCountry") CountryDto updated) {
        fillOut(updated);
        countryService.update(updated);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteById(@PathVariable(value = "id") int id) {
        countryService.deleteById(id);
        return "redirect:/countries";
    }

    private void fillOut(CountryDto updated) {
        CountryDto current = countryService.findById(updated.getId());
        if (updated.getName() == null)
            updated.setName(current.getName());
        if (updated.getNetworkOperator() == null)
            updated.setNetworkOperator(current.getNetworkOperator());
    }

}
