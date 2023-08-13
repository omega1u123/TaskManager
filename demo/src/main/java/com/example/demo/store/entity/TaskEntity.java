package com.example.demo.store.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int priority;

    public TaskEntity(){}

    public TaskEntity(String title, int priority){
        this.title = title;
        this.priority = priority;
    }


}
