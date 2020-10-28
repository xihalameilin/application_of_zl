package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface UserService {
    boolean isValid(String name,String password);

    void addUser(UserEntity userEntity);
}
