package com.innocv.technicaltest2.controllers;

import com.innocv.technicaltest2.domain.User;
import com.innocv.technicaltest2.errors.UserNotFoundException;
import com.innocv.technicaltest2.repositories.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(description = "Manage users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @ApiOperation(value = "List all users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a user")
    public User findOne(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @PostMapping
    @ApiOperation(value = "Create a new user")
    public ResponseEntity createNew(@RequestBody  User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a user")
    public User update(@PathVariable(value = "id") Long id, @RequestBody  User user) {
        userRepository.save(user);
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

}
