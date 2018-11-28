package com.innocv.technicaltest2.controllers;

import com.innocv.technicaltest2.domain.Task;
import com.innocv.technicaltest2.services.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}")
@Api(description = "Manage task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @ApiOperation(value = "List all task of an user")
    public List<Task> findAll(@PathVariable(value = "userId") Long userId) {
        return taskService.findAllTaskOfUser(userId);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a task of user")
    public Task findOne(@PathVariable(value = "userId") Long userId, @PathVariable(value = "id") Long id) {
        return taskService.findOne(id);
    }

    @PostMapping
    @ApiOperation(value = "Create a new task for user")
    public ResponseEntity createNew(@PathVariable(value = "userId") Long userId, @RequestBody  Task task) {
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a task")
    public Task update(@PathVariable(value = "userId") Long userId, @PathVariable(value = "id") Long id, @RequestBody  Task task) {
        return taskService.update(task);
    }

}
