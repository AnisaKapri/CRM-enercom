package com.example.crmenercom.controller;

import com.example.crmenercom.dto.ContactPersonDto;
import com.example.crmenercom.service.ContactPersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactPersonController {

    private final ContactPersonService contactPersonService;


    public ContactPersonController(ContactPersonService contactPersonService) {
        this.contactPersonService = contactPersonService;
    }

    @GetMapping("/read")
    public String getById(@ModelAttribute("contactPerson") ContactPersonDto contactPersonDto, BindingResult bindingResult, Model model){
        contactPersonService.getById(contactPersonDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("contactPerson") ContactPersonDto contactPersonDto, BindingResult bindingResult, Model model){
        contactPersonService.create(contactPersonDto);
        return "index";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("contactPerson") ContactPersonDto contactPersonDto, BindingResult bindingResult, Model model){
        contactPersonService.update(contactPersonDto);
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable (value = "id") int id){
        contactPersonService.deleteById(id);
        return "index";
    }
}
