package com.example.crmenercom.util;

import java.util.Arrays;

public enum ProductStatus {

    STOCK(0, "Stock"),
    SOLD(1, "Sold");

    private final Integer code;
    private final String value;


    ProductStatus(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer code() {
        return code;
    }

    public String value() {
        return value;
    }

    public static String[] getAllStatuses() {
        return Arrays.stream(values())
                .map(ProductStatus::value)
                .toArray(String[]::new);
    }
}
