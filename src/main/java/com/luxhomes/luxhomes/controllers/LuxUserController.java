package com.luxhomes.luxhomes.controllers;

import com.luxhomes.luxhomes.models.LuxUser;
import com.luxhomes.luxhomes.services.LuxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/lux/users")
public class LuxUserController {
    private final LuxUserService userService;

    @Autowired
    public LuxUserController(LuxUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<LuxUser> allUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(path= "/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        return userService.deleteUser(userId);
    }
}
