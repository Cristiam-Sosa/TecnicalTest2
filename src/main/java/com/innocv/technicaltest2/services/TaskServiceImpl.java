package com.innocv.technicaltest2.services;

import com.innocv.technicaltest2.domain.Task;
import com.innocv.technicaltest2.domain.User;
import com.innocv.technicaltest2.errors.TaskNotFoundException;
import com.innocv.technicaltest2.errors.UserNotFoundException;
import com.innocv.technicaltest2.repositories.TaskRepository;
import com.innocv.technicaltest2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Task> findAllTaskOfUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return taskRepository.findAllByUser(user);
    }

    @Override
    public Task findOne(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    }

    @Override
    public void create(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

}
