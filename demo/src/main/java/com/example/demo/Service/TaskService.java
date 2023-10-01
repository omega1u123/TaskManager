package com.example.demo.Service;

import com.example.demo.store.entity.TaskEntity;
import com.example.demo.store.repo.TaskRepo;
import com.example.demo.store.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Service
public class TaskService {

    private final TaskRepo taskRepo;
    private final UserService userService;

    private final UserRepo userRepo;

    public TaskService(TaskRepo taskRepo, UserService userService, UserRepo userRepo) {
        this.taskRepo = taskRepo;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    public ModelAndView startPage(){
        ModelAndView page = new ModelAndView("start_page.html");
        return page;
    }

    public ModelAndView taskListPage(){
        ModelAndView page = new ModelAndView("task_list.html");
        page.addObject("task", taskRepo.findAll());
        return page;
    }

    public void addTask(String title, int priority){
      TaskEntity task = new TaskEntity(title, priority);
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      task.setUserEntity(userRepo.findByLogin(auth.getName()));
      System.out.println(task.getUserEntity());
      taskRepo.save(task);
      userService.addTask(task);

    }

    public void deleteTask(long id){
        taskRepo.deleteById(id);
    }


    public Optional<TaskEntity> getTask(Long id){
        return taskRepo.findById(id);
    }
    
    public Iterable<TaskEntity> getAllTasks(){
       return taskRepo.findAll();
    }


}
