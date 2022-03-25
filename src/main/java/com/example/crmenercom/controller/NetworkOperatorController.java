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
import java.util.List;

@Controller
@RequestMapping("networkOperators")
public class NetworkOperatorController {

    private static final String
            NETOP_LIST = "networkOperator/list",
            COUNTRY_LIST = "country/list";

    private final AuthController auth;
    private final NetworkOperatorService networkOperatorService;
    private final CountryService countryService;

    @Autowired
    public NetworkOperatorController(AuthController auth, NetworkOperatorService networkOperatorService, CountryService countryService) {
        this.auth = auth;
        this.networkOperatorService = networkOperatorService;
        this.countryService = countryService;
    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }


    @GetMapping({"/", ""})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<NetworkOperatorDto> networkOperators = networkOperatorService.selectAll();
        for (NetworkOperatorDto netOp : networkOperators)
            netOp.setNumOfCountries(countryService.getNumOfCountries(netOp));
        model.addAttribute("updateNetOp", new UpdateDto());
        model.addAttribute("deleteNetOp", new NetworkOperatorDto());
        model.addAttribute("networkOperators", networkOperators);
        return NETOP_LIST;
    }

    @GetMapping("$/{name}")
    private String getCountries(@PathVariable(value = "name") String networkOperator, Model model) {
        addLoggedInUser(model);
        List<CountryDto> countries = countryService.selectAllByNetworkOperator(networkOperator);
        model.addAttribute("countries", countries);
        model.addAttribute("updateCountries", new UpdateDto());
        return COUNTRY_LIST;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "newNetOp") @Valid NetworkOperatorDto newNetOp,
                      BindingResult result, Model model) {
        addLoggedInUser(model);
        if (result.hasErrors()) return NETOP_LIST;
        if (networkOperatorService.exist(newNetOp)) {
            model.addAttribute("nonUniqueNetOpError", Utils.NetOpNotUnique(newNetOp));
        } else {
            networkOperatorService.add(newNetOp);
        }
        return getAll(model);
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateNetOp") UpdateDto updateNetOp,
                         BindingResult result, Model model) {
        if (result.hasErrors()) return NETOP_LIST;
        NetworkOperatorDto currentNetOp = new NetworkOperatorDto(updateNetOp.getCurrent());
        NetworkOperatorDto updatedNetOp = new NetworkOperatorDto(updateNetOp.getUpdated());
        if (networkOperatorService.exist(updatedNetOp)) {
            model.addAttribute("nonUniqueNetOpError", Utils.NetOpNotUnique(currentNetOp));
        } else {
            networkOperatorService.add(updatedNetOp);
            countryService.updateNetworkOperator(currentNetOp, updatedNetOp);
            networkOperatorService.delete(currentNetOp);
        }
        return "redirect:/networkOperators";
    }

    @PostMapping("/delete")
    private String delete(@ModelAttribute(name = "deleteNetOp") NetworkOperatorDto deleteNetOp) {
        networkOperatorService.delete(deleteNetOp);
        return "redirect:/networkOperators";
    }
}
