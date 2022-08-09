package com.devbell.userdepart.controllers;

import com.devbell.userdepart.entities.User;
import com.devbell.userdepart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        return repository.findAll();
    }
    @GetMapping(value = "/{id}")
    public User findOne(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @PostMapping
    public User saveOne(@RequestBody User user){
        return repository.save(user);
    }
//    @PutMapping(value = "/users/{id}")
//    public User update(@PathVariable Long id){
//
//    }
    @DeleteMapping("/users/{id}")
    public void deleteOne(@PathVariable Long id){
         repository.deleteById(id);
    }
}
