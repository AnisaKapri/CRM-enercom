package com.example.crmenercom.controller;

import com.example.crmenercom.dto.ClientDto;
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
@RequestMapping("/clients")
public class ClientController {

    private static final String
            CLIENT_LIST = "clients/list",
            CLIENT_BY_ID = "client/id",
            RESULT = "client/result",
            FORM= "client/form",
            ERROR = "error";


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
    public String getAll(Model model){
        addLoggedInUser(model);
        List<ClientDto> clients = clientService.selectAll();
        model.addAttribute("clients", clients);
        model.addAttribute("updatedClient", new ClientDto());
        return CLIENT_LIST;
    }


    @GetMapping("{id}")
    public String getById(Model model, @PathVariable(value = "id") Integer id){
        ClientDto client = clientService.findById(id);
        if(client == null){
            model.addAttribute("error", Utils.CLIENT_NOT_FOUND);
            return ERROR;
        }else {
            addLoggedInUser(model);
          //  getClientData(model, client);
            return CLIENT_BY_ID;
        }
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "client") @Valid ClientDto client, BindingResult result,Model model){
        addLoggedInUser(model);
        if(result.hasErrors()) return FORM;

        return null; //kontrollo
    }

    @PutMapping("/updateClient")
    public String update(@ModelAttribute("address") ClientDto clientDto, BindingResult bindingResult, Model model) {
        clientService.update(clientDto);
        return "index";
    } //KONTROLLO


    @RequestMapping(value = "{id}/delete")
    public String deleteById(@PathVariable(value = "id") Integer id){
        clientService.deleteById(id);
        return "redirect:/clients";
    }




 /*   @GetMapping("/readClient")
    public String getById(@ModelAttribute("client") ClientDto clientDto, BindingResult bindingResult, Model model) {
        clientService.getById(clientDto.getId());
        return "index";  // NDRYSHO
    }

    @PostMapping("/saveClient")
    public String create(@ModelAttribute("applicationModule") ClientDto clientDto, BindingResult bindingResult, Model model) {
        clientService.create(clientDto);
        return "index";
    }


    @DeleteMapping("/deleteClient/{id}")
    public String deleteById(@PathVariable(value = "id") int id) {
        clientService.deleteById(id);
        return "index";
    }

  */

}


