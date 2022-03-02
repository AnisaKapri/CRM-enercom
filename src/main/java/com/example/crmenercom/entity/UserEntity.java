package com.example.crmenercom.entity;

import lombok.*;
import javax.persistence.*;

@Entity @Table(name = "user")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    public UserEntity(String firstName, String lastName, String email, String encode) {
    }
}
