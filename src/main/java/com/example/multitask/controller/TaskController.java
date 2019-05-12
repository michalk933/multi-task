package com.example.multitask.controller;

import com.example.multitask.dto.Task;
import com.example.multitask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public void task() {
        List<Task> tasks = IntStream.range(0, 20)
                .mapToObj(num -> Task.builder()
                        .id(num)
                        .name("name" + num)
                        .build()
                )
                .collect(Collectors.toList());

        taskService.makeTask(tasks);
    }

}
