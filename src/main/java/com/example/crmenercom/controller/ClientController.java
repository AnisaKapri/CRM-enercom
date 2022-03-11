package com.example.crmenercom.controller;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/read")
    public String getById(@ModelAttribute("client") ClientDto clientDto, BindingResult bindingResult, Model model){
        clientService.getById(clientDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("applicationModule") ClientDto clientDto, BindingResult bindingResult, Model model){
        clientService.create(clientDto);
        return "index";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("address") ClientDto clientDto, BindingResult bindingResult, Model model){
        clientService.update(clientDto);
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable (value = "id") int id){
        clientService.deleteById(id);
        return "index";
    }

}
