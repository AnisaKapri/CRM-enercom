package com.example.crmenercom.dto;

import com.example.crmenercom.entity.OrderEntity;
import com.example.crmenercom.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int id;
    @Pattern(regexp = Utils.MULT_NAMES_REGEX, message = "Product name is invalid!")
    private String name;
    private String price;
    private List<OrderEntity> orders = new ArrayList<>();
}
