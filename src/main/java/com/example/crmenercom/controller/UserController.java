package com.example.crmenercom.controller;

import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping({"/list"})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<UserDto> users = userService.selectAll();
        model.addAttribute("customers", users);
        return LIST;
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteById(@PathVariable(value = "id") int id) {
        userService.deleteById(id);
        return "redirect:/users/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateUser") UserDto updated) {
        fillOut(updated);
        userService.update(updated);
        return "redirect:/users";
    }

    private void fillOut(UserDto updated) {
        UserDto current = userService.findById(updated.getId());
        if (updated.getRole() == null)
            updated.setRole(current.getRole());
        if (updated.getFirstName() == null)
            updated.setFirstName(current.getFirstName());
        if (updated.getLastName() == null)
            updated.setLastName(current.getLastName());
        if (updated.getEmail() == null)
            updated.setEmail(current.getEmail());
        if (updated.getPassword() == null)
            updated.setPassword(current.getPassword());
    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }
}
