package com.example.crmenercom.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;



}
