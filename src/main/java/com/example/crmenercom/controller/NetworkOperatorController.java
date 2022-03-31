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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/networkOperators")
public class NetworkOperatorController {

    private static final String
            NETOP_LIST = "networkOperator/list",
            NETOP_BY_ID = "networkOperator/id",
            RESULT = "networkOperator/result",
            FORM = "networkOperator/form",
            ERROR = "error";

    private final AuthController auth;
    private final NetworkOperatorService networkOperatorService;
    private final UserService userService;
    private final CountryService countryService;

    @Autowired
    public NetworkOperatorController(AuthController auth, NetworkOperatorService networkOperatorService , UserService userService, CountryService countryService) {
        this.auth = auth;
        this.networkOperatorService = networkOperatorService;
        this.userService = userService;
        this.countryService = countryService;
    }


    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }


    @GetMapping({"/", ""})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<NetworkOperatorDto> networkOperators = networkOperatorService.selectAll();
        List<CountryDto> countries = countryService.selectAll();
        model.addAttribute("networkOperators", networkOperators);
        model.addAttribute("countries", countries);
        model.addAttribute("updateNetworkOperator", new NetworkOperatorDto());
        return NETOP_LIST;
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable(value = "id") Long id) {
        NetworkOperatorDto networkOperator = networkOperatorService.findById(id);
        if (networkOperator == null) {
            model.addAttribute("error", Utils.NETOP_NOT_FOUND);
            return ERROR;
        } else {
            addLoggedInUser(model);
            model.addAttribute("networkOperator", networkOperator);
            return NETOP_BY_ID;
        }
    }


    @GetMapping("/create")
    public String createForm(@ModelAttribute(name = "networkOperator") @Valid NetworkOperatorDto networkOperator,
                             BindingResult result, Model model) {
        addLoggedInUser(model);
        List<CountryDto> countries = countryService.selectAll();
        model.addAttribute("countries", countries);
        model.addAttribute("networkOperator", new NetworkOperatorDto());
        return FORM;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "networkOperator") @Valid NetworkOperatorDto networkOperator,
                      BindingResult result, Model model) {
        addLoggedInUser(model);
        if (result.hasErrors()) return FORM;
        if (networkOperatorService.isUnique(networkOperator)) {
            model.addAttribute("countries", countryService.selectAll());
            model.addAttribute("nonUniqueItemError", Utils.NetOpNotUnique(networkOperator));
            return FORM;
        }
        model.addAttribute("networkOperator", networkOperatorService.add(networkOperator));
        return RESULT;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateNetworkOperator") NetworkOperatorDto updated) {
        fillOut(updated);
        networkOperatorService.update(updated);
        return "redirect:/networkOperators";
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteById(@PathVariable(value = "id") Long id) {
        networkOperatorService.deleteById(id);
        return "redirect:/networkOperators";
    }

    private void fillOut(NetworkOperatorDto updated) {
        NetworkOperatorDto current = networkOperatorService.findById(updated.getId());
        if (updated.getName() == null)
            updated.setName(current.getName());
        if (updated.getCountry() == null)
            updated.setCountry(current.getCountry());
    }
}
