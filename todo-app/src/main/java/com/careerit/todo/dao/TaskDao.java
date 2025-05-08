package com.careerit.todo.dao;

import com.careerit.todo.domain.Priority;
import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskDao {
    Task insertTask(Task task);
    Task updateTask(Task task);
    Task selectById(String id);
    boolean deleteTask(UUID id);
    List<Task> selectActiveTasks();
    List<Task> selectArchivedTasks();
    List<Task> search(String title, Priority priority, Status status);
    List<Task> addAllTasks(List<Task> tasks);
    Task updateStatus(UUID id, Status status);
}
