package com.example.demo.controller;

import com.example.demo.Service.TaskService;
import com.example.demo.store.entity.TaskEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Controller {

    private final TaskService taskService;


    public Controller(TaskService taskService){
        this.taskService = taskService;

    }


    @PostMapping("/add_task")
    public void addTask(@RequestParam("id") long id, @RequestParam("title") String title, @RequestParam("priority") int priority){
        taskService.addTask(id, title, priority);
    }

    @PostMapping("/delete_task")
    public void deleteTask(@RequestParam long id){
        taskService.deleteTask(id);
    }

    @GetMapping("/get_task")
    public Optional<TaskEntity> getTask(@RequestParam long id ){
        return  taskService.getTask(id);
    }

    @GetMapping("/all")
    public Iterable<TaskEntity> getAllTasks(){
       return taskService.getAllTasks();
    }

}
