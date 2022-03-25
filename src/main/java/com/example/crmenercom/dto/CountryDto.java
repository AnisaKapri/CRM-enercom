package com.example.crmenercom.dto;

import com.example.crmenercom.util.Utils;
import lombok.*;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CountryDto {
    private Integer id;
    @Pattern(regexp = Utils.MULT_NAMES_REGEX, message = "Country name is invalid!")
    private String name;
    private String networkOperator;

    public CountryDto() {
    }

    public CountryDto(CountryDto c) {
        id = c.id;
        name = c.name;
        networkOperator = c.networkOperator;
    }


    public void setName(String name) {
        this.name = Utils.capFirst(name);
    }

    public void setNetworkOperator(String networkOperator) {
        this.networkOperator = Utils.capFirst(networkOperator);
    }

    public void setNetworkOperator(NetworkOperatorDto networkOperator) {
        this.networkOperator = Utils.capFirst(String.valueOf(networkOperator));
    }



    public boolean equals(CountryDto netOp) {
        return this == netOp || id.equals(netOp.id)
                && name.equals(netOp.name)
                && networkOperator.equals(netOp.networkOperator);
    }

    public boolean equalsLogically(CountryDto c) {
        return this == c || name.equals(c.name)
                && networkOperator.equals(c.networkOperator);
    }

    public boolean isOf(String networkOperator) {
        return this.networkOperator.equals(networkOperator);
    }

}
