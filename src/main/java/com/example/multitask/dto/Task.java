package com.example.multitask.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {

    private int id;

    private String name;

}
