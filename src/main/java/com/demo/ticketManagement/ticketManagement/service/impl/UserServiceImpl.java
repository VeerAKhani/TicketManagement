package com.demo.ticketManagement.ticketManagement.service.impl;

import com.demo.ticketManagement.ticketManagement.model.User;
import com.demo.ticketManagement.ticketManagement.repository.UserRepository;
import com.demo.ticketManagement.ticketManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(String userName) {
        if(!ObjectUtils.isEmpty(userName)){
            User user = new User(userName);
            userRepository.save(user);
            return user;
        }
        return null;
    }
}
