package com.example.demo.controller;

import com.example.demo.Service.TaskService;
import com.example.demo.store.MyUserDetails;
import com.example.demo.store.entity.FormEntity;
import com.example.demo.store.entity.TaskEntity;
import com.example.demo.store.entity.UserEntity;
import com.example.demo.store.repo.TaskRepo;
import com.example.demo.store.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FormController {

    private final TaskService taskService;
    private final TaskRepo taskRepo;
    private final UserRepo userRepo;


    public FormController(TaskService taskService, TaskRepo taskRepo, UserRepo userRepo){
        this.taskService = taskService;
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/page")
    public String getTaskList(Model model){
        List<TaskEntity> taskList = userRepo.findByLogin("ilya").getTasks();
        //Iterable<TaskEntity> taskList = taskService.getAllTasks();
        model.addAttribute("task", taskList);
        return "task_list";
    }

    @GetMapping("/form")
    public String addTask(Model model){
        FormEntity form = new FormEntity();
        model.addAttribute("form", form);
        return "task_form";
    }

    @PostMapping("/form/save")
    public String saveTask(Model model, @ModelAttribute("form") FormEntity form){
        TaskEntity task = new TaskEntity(form.getTitle(), form.getPriority());
        model.addAttribute("form", task);
        taskRepo.save(task);
        return "redirect:/page";
    }


}
