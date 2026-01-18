package com.firstproject.firstp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstproject.firstp.service.UserService;
import com.firstproject.firstp.dto.Userdto;
import com.firstproject.firstp.model.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;




@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public User createUser(@RequestBody Userdto userdto){
        return userService.createUser(userdto);
    }

    @GetMapping
    public Page<User> getUsers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction) {

    return userService.getAllUsers(page, size, sortBy, direction);
}

    

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User putMethodName(@PathVariable Long id, @RequestBody Userdto userdto) {
        return userService.updateUser(id, userdto);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
