package com.example.demo.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id
    private Long id;

    private String login;

    private String password;

    @OneToMany
    private List<TaskEntity> tasks;


    public UserEntity(){}
    public UserEntity(Long id,String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }

}
