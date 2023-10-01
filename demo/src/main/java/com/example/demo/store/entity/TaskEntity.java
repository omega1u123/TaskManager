package com.example.demo.store.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "task")
public class TaskEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private int priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public TaskEntity(){}

    public TaskEntity(String title, int priority){
        this.title = title;
        this.priority = priority;
    }


}
