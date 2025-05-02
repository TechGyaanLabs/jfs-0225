package com.careerit.todo.dao;

import com.careerit.todo.domain.Priority;
import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;

import java.util.List;

public interface TaskDao {
    Task insertTask(Task task);
    Task updateTask(Task task);
    Task selectById(String id);
    boolean deleteTask(String id);
    List<Task> selectActiveTasks();
    List<Task> selectArchivedTasks();
    List<Task> search(String title, Priority priority, Status status);
}
