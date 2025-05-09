package com.careerit.todo.service;

import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(Task task);
    Task updateTask(Task task);
    Task getTaskById(String id);
    boolean deleteTask(UUID id);
    List<Task> getAllActiveTasks();
    List<Task> getArchivedTasks();
    List<Task> search(String title, boolean flag);
    List<Task> addAllTasks(List<Task> tasks);
    Task updateStatus(UUID id, Status status);

}
