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

    @GetMapping("/readContactPerson")
    public String getById(@ModelAttribute("contactPerson") ContactPersonDto contactPersonDto, BindingResult bindingResult, Model model) {
        contactPersonService.getById(contactPersonDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveContactPerson")
    public String create(@ModelAttribute("contactPerson") ContactPersonDto contactPersonDto, BindingResult bindingResult, Model model) {
        contactPersonService.create(contactPersonDto);
        return "index";
    }

    @PutMapping("/updateContactPerson")
    public String update(@ModelAttribute("contactPerson") ContactPersonDto contactPersonDto, BindingResult bindingResult, Model model) {
        contactPersonService.update(contactPersonDto);
        return "index";
    }

    @DeleteMapping("/deleteContactPerson/{id}")
    public String deleteById(@PathVariable(value = "id") Long id) {
        contactPersonService.deleteById(id);
        return "index";
    }
}
