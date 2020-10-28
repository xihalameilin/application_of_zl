package com.example.demo.service.Impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean isValid(String name, String password) {
        UserEntity user = userRepository.findUserEntitiesByName(name);
        if(password.equals(user.getPassword()))
            return true;
        return false;
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
