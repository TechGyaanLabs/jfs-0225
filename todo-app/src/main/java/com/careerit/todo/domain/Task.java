package com.careerit.todo.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Task {
    private UUID id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private Status status;
}
