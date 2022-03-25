package com.example.crmenercom.controller;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.entity.ClientEntity;
import com.example.crmenercom.service.ClientService;
import com.example.crmenercom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("clients")
public class ClientController {

    private static final String
            CLIENT_LIST = "client/list",
            CLIENT_BY_ID = "client/id",
            RESULT = "client/result",
            FORM = "client/form",
            ERROR = "error";


    private final ClientService clientService;
    private final UserService userService;
    private final AuthController auth;

    @Autowired
    public ClientController(ClientService clientService, UserService userService, AuthController auth) {
        this.clientService = clientService;
        this.userService = userService;
        this.auth = auth;
    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }



    @GetMapping("")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewClientForm")
    public String showNewClientForm(Model model){
        ClientDto client = new ClientDto();
        model.addAttribute("client", client);
        return "new_client";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") ClientEntity client){
        clientService.saveClient(client);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdated/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") int id, Model model){
        ClientEntity client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "update_client";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(value = "id") int id){
        this.clientService.deleteClientById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize = 5;

        Page<ClientEntity> page = clientService.findPaginated(pageNo, pageSize, sortField, sortDir );
        List<ClientEntity> listClients = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listClients", listClients);
        return "list";
    }

   /* SAKTE
    @GetMapping(value = "/client/list")
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<ClientDto> clients = clientService.selectAll();
      // List<ClientEntity> clients = clientService.findAll();
        model.addAttribute("customers", clients);
        model.addAttribute("updatedClient", new ClientDto());
        return CLIENT_LIST;
    }

    */




   /* @GetMapping("{id}")
    public String getById(Model model, @PathVariable(value = "id") Integer id){
        ClientDto client = clientService.findById(id);
        if(client == null){
            model.addAttribute("error", Utils.CLIENT_NOT_FOUND);
            return ERROR;
        }else {
            addLoggedInUser(model);
            getClientData(model, client);
            return CLIENT_BY_ID;
        }
    }

    */


  /*  SAKTE
  @RequestMapping(value = "{id}/delete")
    public String deleteById(@PathVariable(value = "id") Integer id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }

   */

    /*
    @PostMapping("/add")
    public String add(@ModelAttribute(name = "client") @Valid ClientDto client, BindingResult result,Model model){
        addLoggedInUser(model);
        if(result.hasErrors()) return FORM;
        getClientData(model, clientService.add(client));
        return RESULT; //kontrollo
    }


    @PutMapping("/update")
    public String update(@ModelAttribute(name = "updateClient") ClientDto clientDto) {
        fillOut(updated);
        clientService.update(updated);
        return "redirect:/clients";
    } //KONTROLLO


    private void getClientData(Model model, ClientDto clients){
        model.addAttribute("client", clients);

        if (!clients.isEmpty()){
            System.out.println(clients.size());
            Map<Integer, UserDto> customers = new HashMap<>();
            for ()
        }
    }

     */

}


