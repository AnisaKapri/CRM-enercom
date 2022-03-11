package com.example.crmenercom.controller;

import com.example.crmenercom.dto.ProductDto;
import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.entity.OrderEntity;
import com.example.crmenercom.service.ProductService;
import com.example.crmenercom.service.UserService;
import com.example.crmenercom.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/products")
public class ProductController {

    private static final String
            PRODUCT_LIST = "product/list",
            PRODUCT_BY_ID = "product/id",
            FORM = "product/form",
            RESULT = "product/result",
            ERROR = "error";

    private final AuthController auth;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public ProductController(AuthController auth, ProductService productService, UserService userService) {
        this.auth = auth;
        this.productService = productService;
        this.userService = userService;
    }


    @GetMapping({"/", ""})
    public String getAll(Model model) {
        addLoggedInUser(model);
        List<ProductDto> products = productService.selectAll();
        model.addAttribute("products", products);
        model.addAttribute("updateProduct", new ProductDto());
        return PRODUCT_LIST;
    }

    @GetMapping("/{id}") // TODO: to be deleted
    public String getById(Model model, @PathVariable(value = "id") Integer id) {
        ProductDto product = productService.findById(id);
        if (product == null) {
            model.addAttribute("error", Utils.PRODUCT_NOT_FOUND);
            return ERROR;
        } else {
            addLoggedInUser(model);
            getProductData(model, product);
            return PRODUCT_BY_ID;
        }
    }

    @GetMapping("/create") // TODO: to be deleted
    public String createForm(Model model) {
        addLoggedInUser(model);
        model.addAttribute("product", new ProductDto());
        return FORM;
    }

   @PostMapping("/add") //
    public String add(@ModelAttribute(name = "product") @Valid ProductDto product,
                      BindingResult result, Model model) {
        addLoggedInUser(model);
        if (result.hasErrors()) return FORM;

        if (productService.isUnique(product)) {
            model.addAttribute("nonUniqueItemError", Utils.ProductNotUnique(product));
            return FORM;
        }
        return RESULT;
    }



    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateItem") ProductDto updated) {
        fillOut(updated);
        productService.update(updated);
        return "redirect:/products";
    }


   @RequestMapping(value = "/{id}/delete")
    public String deleteById(@PathVariable(value = "id") Integer id) {
        productService.deleteById(id);
        return "redirect:/products";
    }



    private void getProductData(Model model, ProductDto product) {
        List<OrderEntity> orders = product.getOrder();
        model.addAttribute("product", product);

        if (!orders.isEmpty()) {
            System.out.println(orders.size());
            Map<Integer, UserDto> customers = new HashMap<>();
            for (OrderEntity order : orders) {
                Integer customerId = order.getCustomerId();
                UserDto customer = userService.findById(customerId);
                customers.put(customerId, customer);
            }

            model.addAttribute("orders", orders);
            model.addAttribute("customers", customers);
        }
    }

    private void fillOut(ProductDto updated) {
        ProductDto current = productService.findById(updated.getId());
        if (updated.getName() == null)
            updated.setName(current.getName());
        if (updated.getPrice() == null)
            updated.setPrice(current.getPrice());
    }

    private void addLoggedInUser(Model model) {
        model.addAttribute("user", auth.getLoggedInUser());
    }
}
