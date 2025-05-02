package com.careerit.todo.service;

import com.careerit.todo.domain.Priority;
import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);
    Task updateTask(Task task);
    Task getTaskById(String id);
    boolean deleteTask(String id);
    List<Task> getAllActiveTasks();
    List<Task> getArchivedTasks();
    List<Task> search(String title, Priority priority, Status status);

}
