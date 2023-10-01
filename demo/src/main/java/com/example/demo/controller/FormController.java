package com.example.demo.controller;

import com.example.demo.Service.TaskService;
import com.example.demo.store.entity.TaskEntity;
import com.example.demo.store.model.FormModel;
import com.example.demo.store.repo.TaskRepo;
import com.example.demo.store.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("task", taskRepo.findAllByUserEntity(userRepo.findByLogin(auth.getName())));
        return "task_list";
    }

    @GetMapping("/form")
    public String addTask(Model model){
        FormModel form = new FormModel();
        model.addAttribute("form", form);
        return "task_form";
    }

    @PostMapping("/form/save")
    public String saveTask(Model model, @ModelAttribute("form") FormModel form){
        TaskEntity task = new TaskEntity(form.getTitle(), form.getPriority());
        model.addAttribute("form", task);
        taskService.addTask(form.getTitle(), form.getPriority());
        return "redirect:/page";
    }


}
