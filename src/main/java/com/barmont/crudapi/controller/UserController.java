package com.barmont.crudapi.controller;

import com.barmont.crudapi.model.UserModel;
import com.barmont.crudapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping("/get/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @PutMapping("/update/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id) {
        return this.userService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);

        if (ok) {
            return "User with id: " + id + " DELETED";
        } else {
            return "User with id " + id + " not deleted";
        }
    }
}
