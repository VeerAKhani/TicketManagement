package com.demo.ticketManagement.ticketManagement.controller;

import com.demo.ticketManagement.ticketManagement.model.User;
import com.demo.ticketManagement.ticketManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestPart String userName){
        return userService.saveUser(userName);
    }



}
