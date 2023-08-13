package com.example.demo.controller;

import com.example.demo.Service.TaskService;
import com.example.demo.store.entity.FormEntity;
import com.example.demo.store.entity.TaskEntity;
import com.example.demo.store.repo.TaskRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    private final TaskService taskService;
    private final TaskRepo taskRepo;

    public FormController(TaskService taskService, TaskRepo taskRepo){
        this.taskService = taskService;
        this.taskRepo = taskRepo;
    }

    @GetMapping("/page")
    public String getTaskList(Model model){
        Iterable<TaskEntity> taskList = taskService.getAllTasks();
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
