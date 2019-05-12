package com.example.multitask.service;

import com.example.multitask.dto.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TaskService {

    public void makeTask(List<Task> tasks) {
        System.out.println("TIME START: " + LocalDateTime.now());
        tasks.stream()
                .parallel()
                .forEach(task -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("SOMETHING WRONG DURING SLEEP");
                    }
                    System.out.println("CHECK TASK: " + task);
                });
        System.out.println("TIME END: " + LocalDateTime.now());
    }

}
