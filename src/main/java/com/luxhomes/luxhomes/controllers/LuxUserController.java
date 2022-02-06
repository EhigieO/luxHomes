package com.luxhomes.luxhomes.controllers;

import com.luxhomes.luxhomes.models.LuxUser;
import com.luxhomes.luxhomes.services.LuxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/lux/users")
public class LuxUserController {
    private final LuxUserService userService;

    @Autowired
    public LuxUserController(LuxUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path= "/users")
    public List<LuxUser> allUsers(){
        return userService.getAllUsers();
    }
}
