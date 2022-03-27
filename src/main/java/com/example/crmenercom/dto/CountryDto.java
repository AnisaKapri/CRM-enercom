package com.example.crmenercom.dto;

import com.example.crmenercom.entity.NetworkOperatorEntity;
import com.example.crmenercom.util.Utils;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
public class CountryDto {

    private Long id;
    @Pattern(regexp = Utils.MULT_NAMES_REGEX, message = "Country name is invalid!")
    private String name;
    private List<NetworkOperatorEntity> networkOperators;

    public CountryDto() {
    }

    public CountryDto(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = Utils.capFirst(name);
    }
}
