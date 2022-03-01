package com.example.crmenercom.controller;

import com.example.crmenercom.dto.OrderDto;
import com.example.crmenercom.dto.OrderRequestDto;
import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.service.OrderService;
import com.example.crmenercom.service.ProductService;
import com.example.crmenercom.service.UserService;
import com.example.crmenercom.util.OrderStatus;
import com.example.crmenercom.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private static final String
            LIST = "order/list",
            ACTIVE = "order/active",
            ORDER = "order/id",
            FORM = "order/form",
            RESULT = "order/result",
            ERROR = "error";

    private final AuthController auth;
    private final OrderService orderService;
    private final UserService userService;
    private final ProductService productsService;

    @Autowired
    public OrderController(AuthController auth, OrderService orderService,
                           UserService userService, ProductService productService) {
        this.auth = auth;
        this.orderService = orderService;
        this.userService = userService;
        this.productsService = productService;
    }

    @GetMapping({"/", ""})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<OrderDto> orders = orderService.selectAll();
        List<UserDto> customers = userService.selectAll();
        String[] statuses = OrderStatus.getAllStatuses();
        model.addAttribute("orders", orders);
        model.addAttribute("customers", customers);
        model.addAttribute("statuses", statuses);
        return LIST;
    }

    @GetMapping("/active") // WIP -> select only active orders
    public String getActive(Model model) {
        addLoggedInUser(model);
        UserDto user = auth.getLoggedInUser();
        List<OrderDto> orders = orderService.selectAllFromUser(user.getId());
        List<UserDto> customers = userService.selectAll();
        String[] statuses = OrderStatus.getAllStatuses();
        model.addAttribute("orders", orders);
        model.addAttribute("customers", customers);
        model.addAttribute("statuses", statuses);
        return ACTIVE;
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable(value = "id") Integer id) {
        addLoggedInUser(model);
        OrderDto order = orderService.findById(id);
        if (order == null) {
            model.addAttribute("error", Utils.ORDER_NOT_FOUND); // TODO: to be deleted
            return ERROR;
        } else {
            UserDto customer = userService.findById(order.getCustomerId());
            List<ProductDto> products = order.getProduct();
            model.addAttribute("order", order);
            model.addAttribute("customer", customer);
            return ORDER;
        }
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        addLoggedInUser(model);
        List<ProductDto> products = productsService.selectAll();
        model.addAttribute("items", products);
        model.addAttribute("customers", userService.selectAll());
        model.addAttribute("order", new OrderRequestDto(products));
        return FORM;
    }

    @PostMapping("/add")
    public String addOrder(Model model, @ModelAttribute(name = "order") OrderRequestDto order) {
        addLoggedInUser(model);
        List<ProductDto> products = new ArrayList<>();
        Set<Integer> itemIds = order.getProductIds().keySet();
        for (Integer itemId : itemIds)
            if (order.getProductIds().get(itemId))
                products.add(productsService.findById(itemId));
        Integer customerId = order.getCustomerId();
        OrderDto newOrder = orderService.add(customerId, products);
        UserDto customer = userService.findById(customerId);
        model.addAttribute("items", products);
        model.addAttribute("newOrder", newOrder);
        model.addAttribute("customer", customer);
        return RESULT;
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteById(@PathVariable(value = "id") Integer id) {
        orderService.deleteById(id);
        return "redirect:/orders";
    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }
}
