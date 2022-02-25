package com.example.crmenercom.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;

    public UserEntity(int id, String role, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String email, String encode) {
    }
}
