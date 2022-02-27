package com.example.crmenercom.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Data
@Builder
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


   /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )

    */

    public UserEntity(int id, String role, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserEntity(String firstName, String lastName, String email, String encode) {
    }

    public UserEntity() {
    }
}
