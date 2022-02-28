package com.luxhomes.luxhomes.controllers;

import com.luxhomes.luxhomes.exceptions.UserNotFoundException;
import com.luxhomes.luxhomes.models.LuxUser;
import com.luxhomes.luxhomes.services.LuxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static javax.xml.bind.DatatypeConverter.parseLong;

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


    //need to refactor to use long not string just making test pass?
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        String deletedUsed;
        try {
            deletedUsed = userService.deleteUser(userId);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedUsed, HttpStatus.OK);
    }
}
