package com.example.crmenercom.entity;

import com.example.crmenercom.util.Utils;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "countries")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "country")
    private List<NetworkOperatorEntity> networkOperators;


    public void setName(String name){
        this.name = Utils.capFirst(name);
    }
}
