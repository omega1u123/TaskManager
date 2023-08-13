package com.example.demo.Service;

import com.example.demo.store.entity.UserEntity;
import com.example.demo.store.repo.UserRepo;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(Long id,String login, String password){
        UserEntity user = new UserEntity(id,login, password);
        userRepo.save(user);
    }

    public Iterable<UserEntity> getUser(){
        return userRepo.findAll();
    }

}
