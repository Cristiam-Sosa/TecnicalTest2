package com.innocv.technicaltest2.services;

import com.innocv.technicaltest2.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTaskOfUser(Long userId);

    Task findOne(Long taskId);

    void create(Task task);

    Task update(Task task);

    void delete(Long taskId);
}
