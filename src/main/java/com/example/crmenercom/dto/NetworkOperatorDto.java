package com.example.crmenercom.dto;

import com.example.crmenercom.util.Utils;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class NetworkOperatorDto {

    @Pattern(regexp = Utils.MULT_NAMES_REGEX,message = "Network Operator name is invalid!")
    private int id;
    private String name;
    private Long numOfCountries;

    public NetworkOperatorDto(){
    }

    public NetworkOperatorDto(String name){
        this.name = Utils.capFirst(name);
    }

    public boolean equals(NetworkOperatorDto n){
        if (this == n) return true;
        return name.equals(n.name);
    }

    public boolean equals(String n) {
        return name.equals(n);
    }

}
