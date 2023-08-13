package com.example.demo.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    private String login;

    private String password;

    @OneToMany
    private List<TaskEntity> tasks;

    public UserEntity(String login, String password){
        this.login = login;
        this.password = password;
    }

}
