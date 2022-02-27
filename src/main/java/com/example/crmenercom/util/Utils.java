package com.example.crmenercom.util;

import com.example.crmenercom.dto.ProductDto;

import java.time.LocalDate;
import java.util.Arrays;

public class Utils {
    public static final String
            NAME_REGEX = "^[A-Z][a-z]+$",
            MULT_NAMES_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$",
            EMAIL_REGEX = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z]+\\.[a-z]+$";

    public static final String
            EMAIL_NOT_UNIQUE = "This email already exists!",
            EMAIL_NOT_FOUND = "This email doesn't exist!",
            ORDER_NOT_FOUND = "Requested order could not be found!",
            PRODUCT_NOT_FOUND = "Requested item could not be found!",
            INVALID_PASS = "Password is incorrect!";


    public static String ProductNotUnique(ProductDto product) {
        return String.format("Product \"%s\" already exists!", product.getName());
    }

    public static String capFirst(String str) {
        if (str.contains(" ")) {
            String[] words = str.split(" ");
            Arrays.setAll(words, i -> capFirst(words[i]));
            return String.join(" ", words);
        }
        return Character.toUpperCase(str.charAt(0))
                + str.substring(1).toLowerCase();
    }

    public static String capAll(String str) {
        return str.toUpperCase();
    }
    public static String convertToLongDate(LocalDate localDate) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        String[] info = localDate.toString().split("-");
        int monthIndex = Integer.parseInt(info[1]) - 1;
        return String.format("%s %s %s", info[2], months[monthIndex], info[0]);
    }


}

