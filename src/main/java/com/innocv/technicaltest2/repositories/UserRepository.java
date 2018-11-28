package com.innocv.technicaltest2.repositories;

import com.innocv.technicaltest2.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

}
