package com.example.demo.store.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private int priority;

    public TaskEntity(){}

    public TaskEntity(String title, int priority){
        this.title = title;
        this.priority = priority;
    }


}
