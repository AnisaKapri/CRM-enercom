package com.example.crmenercom.controller;

import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final String LIST = "user/list";
    private final AuthController auth;
    private final UserService userService;

    @Autowired
    public UserController(AuthController auth, UserService userService) {
        this.auth = auth;
        this.userService = userService;
    }



    @GetMapping({"/user/list"})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<UserDto> users = userService.selectAll();
        model.addAttribute("customers", users);
        return LIST;
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteById(@PathVariable(value = "id") Integer id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }

}