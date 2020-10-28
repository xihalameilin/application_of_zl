package com.example.demo.controller;


import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/addUser")
    public String addUser(){
        System.out.println("trigger");
        UserEntity user = new UserEntity();
        user.setName("zl");
        user.setPassword("123");
        userService.addUser(user);
        return "success";
    }

    @GetMapping("/login/{name}/{password}")
    public boolean login(@PathVariable("name") String name,
                         @PathVariable("password") String password){
        return userService.isValid(name,password);
    }
}
