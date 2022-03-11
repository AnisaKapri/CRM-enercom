package com.example.crmenercom.controller;

import com.example.crmenercom.dto.CompanyDto;
import com.example.crmenercom.dto.ContactedByDto;
import com.example.crmenercom.service.ContactedByService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactedByController {

    private final ContactedByService contactedByService;


    public ContactedByController(ContactedByService contactedByService) {
        this.contactedByService = contactedByService;
    }

    @GetMapping("/readContactedBy")
    public String getById(@ModelAttribute("contactedBy") ContactedByDto contactedByDto, BindingResult bindingResult, Model model){
        contactedByService.getById(contactedByDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveContactedBy")
    public String create(@ModelAttribute("contactedBy") ContactedByDto contactedByDto, BindingResult bindingResult, Model model){
        contactedByService.create(contactedByDto);
        return "index";
    }

    @PutMapping("/updateContactedBy")
    public String update(@ModelAttribute("contactedBy") ContactedByDto contactedByDto, BindingResult bindingResult, Model model){
        contactedByService.update(contactedByDto);
        return "index";
    }

    @DeleteMapping("/deleteContactedBy/{id}")
    public String deleteById(@PathVariable (value = "id") int id){
        contactedByService.deleteById(id);
        return "index";
    }

}
