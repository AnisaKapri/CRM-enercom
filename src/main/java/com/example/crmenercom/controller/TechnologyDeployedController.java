package com.example.crmenercom.controller;

import com.example.crmenercom.dto.TechnologyDeployedDto;
import com.example.crmenercom.service.TechnologyDeployedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TechnologyDeployedController {

    private final TechnologyDeployedService technologyDeployedService;

    public TechnologyDeployedController(TechnologyDeployedService technologyDeployedService) {
        this.technologyDeployedService = technologyDeployedService;
    }

    @GetMapping("/readTechnologyDeployed")
    public String getById(@ModelAttribute("technologyDeployed") TechnologyDeployedDto technologyDeployedDto, BindingResult bindingResult, Model model){
        technologyDeployedService.getById(technologyDeployedDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveTechnologyDeployed")
    public String create(@ModelAttribute("technologyDeployed") TechnologyDeployedDto technologyDeployedDto, BindingResult bindingResult, Model model){
        technologyDeployedService.create(technologyDeployedDto);
        return "index";
    }

    @PutMapping("/updateTechnologyDeployed")
    public String update(@ModelAttribute("technologyDeployed") TechnologyDeployedDto technologyDeployedDto, BindingResult bindingResult, Model model){
        technologyDeployedService.update(technologyDeployedDto);
        return "index";
    }

    @DeleteMapping("/deleteTechnologyDeployed/{id}")
    public String deleteById(@PathVariable (value = "id") Long id){
        technologyDeployedService.deleteById(id);
        return "index";
    }
}
