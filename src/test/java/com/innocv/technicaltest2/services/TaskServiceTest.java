package com.innocv.technicaltest2.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskServiceImpl service;


    @Test
    public void findAllTaskOfUser_whenUserNotFound_shouldBeThrowError() {
        //TODO...
    }

}