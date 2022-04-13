package com.example.crmenercom.controller;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.service.ClientService;
import com.example.crmenercom.service.ProductService;
import com.example.crmenercom.util.ProductStatus;
import com.example.crmenercom.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("clients")
public class ClientController {

    private static final String
            CLIENT_LIST = "client/list",
            PRODUCT_LIST = "product/list";
    private final ClientService clientService;
    private final AuthController auth;
    private final ProductService productService;

    @Autowired
    public ClientController(ClientService clientService, AuthController auth, ProductService productService) {
        this.clientService = clientService;
        this.auth = auth;
        this.productService = productService;
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


    @GetMapping("/{company}")
    public String getProduct(@PathVariable(value = "company") String client, Model model) {
        addLoggedInUser(model);
        List<ProductDto> products = productService.selectAllByClient(client);
        List<ClientDto> clients = new ArrayList<>();
        clients.add(clientService.findByCompany(client));
        String[] statuses = ProductStatus.getAllStatuses();
        model.addAttribute("products", products);
        model.addAttribute("updateProduct", new ProductDto());
        model.addAttribute("clients", clients);
        model.addAttribute("statuses", statuses);
        return PRODUCT_LIST;
    }


    @RequestMapping(value = "{id}/delete")
    public String deleteById(@PathVariable(value = "id") Long id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "newClient") @Valid ClientDto newClient,
                      BindingResult result, Model model) {
        addLoggedInUser(model);
        if (result.hasErrors()) return CLIENT_LIST;
        if (clientService.exists(newClient)) {
            model.addAttribute("nonUniqueClientError", Utils.ClientNonUnique(newClient));
        } else {
            clientService.add(newClient);
        }
        return getAll(model);
    }


    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateClient") ClientDto updated) {
        fillOut(updated);
        clientService.update(updated);
        return "redirect:/clients";
    }


    /* public String update(@PathVariable(value = "updateClient") UpdateDto updateClient,
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

     */
    private void fillOut(ClientDto updated) {
        ClientDto current = clientService.findById(updated.getId());
        if (updated.getCountry() == null)
            updated.setCountry(current.getCountry());
        if (updated.getCompany() == null)
            updated.setCompany(current.getCompany());
        if (updated.getOperator() == null)
            updated.setOperator(current.getOperator());
        if (updated.getTechnologyDeployed() == null)
            updated.setTechnologyDeployed(current.getTechnologyDeployed());
        if (updated.getCustomerOfPCT() == null)
            updated.setCustomerOfPCT(current.getCustomerOfPCT());
        if (updated.getCompany() == null)
            updated.setContact(current.getContact());
        if (updated.getTitle() == null)
            updated.setTitle(current.getTitle());
        if (updated.getContactedBy() == null)
            updated.setContactedBy(current.getContactedBy());
    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute(name = "deleteClient") ClientDto deleteClient) {
        clientService.delete(deleteClient);
        return "redirect:clients";
    }

}


