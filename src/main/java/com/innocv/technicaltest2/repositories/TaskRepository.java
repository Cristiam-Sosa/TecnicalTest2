package com.innocv.technicaltest2.repositories;

import com.innocv.technicaltest2.domain.Task;
import com.innocv.technicaltest2.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAllByUser(User user);

}
