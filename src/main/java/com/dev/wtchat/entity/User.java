package com.dev.wtchat.entity;

import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "iconUrl")
    private String iconUrl;

    @Column(name = "status")
    private int status;


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = null;
        this.iconUrl = null;
        this.status = 1;
    }
}
