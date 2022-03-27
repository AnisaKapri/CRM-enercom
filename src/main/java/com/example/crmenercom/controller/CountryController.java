package com.example.crmenercom.controller;


import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.dto.NetworkOperatorDto;
import com.example.crmenercom.dto.UpdateDto;
import com.example.crmenercom.service.CountryService;
import com.example.crmenercom.service.NetworkOperatorService;
import com.example.crmenercom.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/countries")
public class CountryController {

    private static final String
            COUNTRY_LIST = "country/list",
            NETOP_LIST = "networkOperator/list";

    private final AuthController auth;
    private final CountryService countryService;
    private final NetworkOperatorService networkOperatorService;


    @Autowired
    public CountryController(AuthController auth, CountryService countryService, NetworkOperatorService networkOperatorService) {
        this.auth = auth;
        this.countryService = countryService;
        this.networkOperatorService = networkOperatorService;

    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }

    @GetMapping({"/", ""})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<CountryDto> countries = countryService.selectAll();
        model.addAttribute("countries", countries);
        return COUNTRY_LIST;
    }


    @GetMapping("/{name}")
    public String getNetworkOperators(@PathVariable(value = "name") String country, Model model) {
        addLoggedInUser(model);
        List<NetworkOperatorDto> networkOperators = networkOperatorService.selectAllByCountry(country);
        List<CountryDto> countries = new ArrayList<>();
        countries.add(countryService.findByName(country));
        model.addAttribute("networkOperators", networkOperators);
        model.addAttribute("updateNetworkOperator", new NetworkOperatorDto());
        model.addAttribute("countries", countries);
        return NETOP_LIST;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "newCnt") @Valid CountryDto newCnt,
                      BindingResult result, Model model) {
        addLoggedInUser(model);
        if (result.hasErrors()) return COUNTRY_LIST;
        if (countryService.exists(newCnt)) {
            model.addAttribute("nonUniqueCntError", Utils.CntNotUnique(newCnt));
        } else { // else add the new category
            countryService.add(newCnt);
        }
        return getAll(model);
    }


    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateCnt") UpdateDto updateCnt,
                         BindingResult result, Model model) {
        if (result.hasErrors()) return COUNTRY_LIST;
        CountryDto currentCnt = new CountryDto(updateCnt.getCurrent());
        CountryDto updatedCnt = new CountryDto(updateCnt.getUpdated());
        if (countryService.exists(updatedCnt)) {
            model.addAttribute(("nonUniqueCntError"), Utils.CntNotUnique(currentCnt));
        } else {
            countryService.add(updatedCnt);
            networkOperatorService.updateCountry(currentCnt, updatedCnt);
            countryService.delete(currentCnt);
        }
        return "redirect:/countries";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute(name = "deleteCnt") CountryDto deleteCnt) {
        countryService.delete(deleteCnt);
        return "redirect:/countries";
    }
}
