//package com.example.demo.controller;
//
//import com.example.demo.store.entity.UserEntity;
//import com.example.demo.store.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class LoginController {
//    @Autowired
//    private UserRepo userRepo;
//
//    @GetMapping("/login_form")
//    public String loginForm(Model model){
//        UserEntity userForm = new UserEntity();
//        model.addAttribute("userForm", userForm);
//        return "login_page";
//    }
//
//    @PostMapping("/login_form/confirm")
//    public void loginConf(Model model, @ModelAttribute("userForm") UserEntity userForm){
//        UserEntity user = new UserEntity(userForm.getLogin(), userForm.getPassword(), "USER");
//        model.addAttribute("userForm", user);
//        userRepo.save(user);
//    }
//}
