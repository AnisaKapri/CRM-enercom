package com.example.crmenercom.dto;

import com.example.crmenercom.entity.CountryEntity;
import com.example.crmenercom.util.Utils;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.util.Objects;

@Getter
@Setter
public class NetworkOperatorDto {

    @Pattern(regexp = Utils.MULT_NAMES_REGEX, message = "Network Operator name is invalid!")
    private Long id;
    private String name;
    private CountryEntity country;

    public NetworkOperatorDto() {
    }

    public NetworkOperatorDto(Long id, String name, CountryEntity country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public void setName(String name) {
        this.name = Utils.capFirst(name);
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkOperatorDto that = (NetworkOperatorDto) o;
        return id.equals(that.id)
                && name.equals(that.name)
                && Objects.equals(country, that.country);
    }

    public boolean equalsLogically(NetworkOperatorDto networkOperator) {
        return this == networkOperator || name.equals(networkOperator.name)
                && country.equals(networkOperator.country);
    }

    public boolean isOf(String country) {
        return this.country.equals(country);
    }
}
