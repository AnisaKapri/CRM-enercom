package com.example.crmenercom.entity;

import com.example.crmenercom.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "network_operators")
public class NetworkOperatorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public void setName(String name) {
        this.name = Utils.capFirst(name);
    }
}
