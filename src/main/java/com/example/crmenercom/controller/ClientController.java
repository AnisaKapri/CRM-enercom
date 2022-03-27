package com.example.crmenercom.controller;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.dto.UpdateDto;
import com.example.crmenercom.service.ClientService;
import com.example.crmenercom.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("clients")
public class ClientController {

    private static final String CLIENT_LIST = "client/list";
    private final ClientService clientService;
    private final AuthController auth;

    @Autowired
    public ClientController(ClientService clientService, AuthController auth) {
        this.clientService = clientService;
        this.auth = auth;
    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }

    @GetMapping({"/", ""})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<ClientDto> clients = clientService.selectAll();
        model.addAttribute("clients", clients);
        model.addAttribute("updateClient", new ClientDto());
        return CLIENT_LIST;
    }

    @RequestMapping(value = "{id}/delete")
    public String deleteById(@PathVariable(value = "id") Long id) {
        clientService.deleteById(id);
        return "redirect/clients";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "newClient") @Valid ClientDto newClient,
                      BindingResult result, Model model){
        addLoggedInUser(model);
        if (result.hasErrors()) return CLIENT_LIST;
        if (clientService.exists(newClient)){
            model.addAttribute("nonUniqueClientError", Utils.ClientNonUnique(newClient));
        }else {
            clientService.add(newClient);
        }
        return getAll(model);
    }

    @PostMapping("/update")
    public String update(@PathVariable(value = "updateClient") UpdateDto updateClient,
                         BindingResult result, Model model) {
        if (result.hasErrors()) return CLIENT_LIST;
        ClientDto currentClient = new ClientDto(updateClient.getCurrent());
        ClientDto updatedClient = new ClientDto(updateClient.getUpdated());
        if (clientService.exists(updatedClient)) {
            model.addAttribute(("nonUniqueClientError"), Utils.ClientNonUnique(currentClient));
        } else {
            clientService.add(updatedClient);
            clientService.delete(currentClient);
        }
        return "redirect:/clients";
    }

}


