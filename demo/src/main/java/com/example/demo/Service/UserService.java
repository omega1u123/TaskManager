package com.example.demo.Service;

import com.example.demo.store.entity.TaskEntity;
import com.example.demo.store.entity.UserEntity;
import com.example.demo.store.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final MyUserDetailsService userDetailsService;

    private List<TaskEntity> tasks;

    public UserService(UserRepo userRepo, MyUserDetailsService userDetailsService) {
        this.userRepo = userRepo;
        this.userDetailsService = userDetailsService;
    }

    public void addTask(TaskEntity task){
        tasks.add(task);
        userRepo.findByLogin("ilya").setTasks(tasks);
    }

}
