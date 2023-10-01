package com.example.demo.Service;

import com.example.demo.store.entity.TaskEntity;
import com.example.demo.store.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addTask(TaskEntity task){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userRepo.findByLogin(auth.getName()).getTasks().add(task);
    }

}
