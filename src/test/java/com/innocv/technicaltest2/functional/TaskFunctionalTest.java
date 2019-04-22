package com.innocv.technicaltest2.functional;

import com.innocv.technicaltest2.TechnicalTest2Application;
import com.innocv.technicaltest2.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TechnicalTest2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class TaskFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void withSecurityDataOfUser1AndRequestTaskOfUser2_shouldReturn401 () {
        //TODO: Add security credentials for US1

        ResponseEntity<Task[]> tasks = restTemplate.getForEntity("/user/2/task", Task[].class);

        assertThat(tasks.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
    }

}
