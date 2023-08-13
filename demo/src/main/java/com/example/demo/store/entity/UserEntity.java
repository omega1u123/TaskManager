package com.example.demo.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;

    private String login;

    private String password;


    public UserEntity(){}
    public UserEntity(String login, String password){
        this.login = login;
        this.password = password;
    }

}
