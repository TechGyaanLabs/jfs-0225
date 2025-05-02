package com.careerit.todo.dao;

import com.careerit.todo.domain.Priority;
import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Slf4j
public class TaskDaoImpl implements TaskDao{

    private List<Task> tasks = new ArrayList<>();

    @Override
    public Task insertTask(Task task) {
        UUID uuid = UUID.randomUUID();
        task.setId(uuid);
        tasks.add(task);
        log.info("Task inserted with id: {}", uuid);
        return task;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public Task selectById(String id) {
        return null;
    }

    @Override
    public boolean deleteTask(String id) {
        return false;
    }

    @Override
    public List<Task> selectActiveTasks() {
        if(tasks.isEmpty()){
            log.info("No tasks are added yet, please add some tasks");
            return List.of();
        } else {
         return tasks
                    .stream()
                    .filter(task -> task.getStatus() != Status.ARCHIVED && task.getStatus() != Status.COMPLETED)
                    .toList();
        }
    }

    @Override
    public List<Task> selectArchivedTasks() {
        return List.of();
    }

    @Override
    public List<Task> search(String title, Priority priority, Status status) {
        return List.of();
    }
}
