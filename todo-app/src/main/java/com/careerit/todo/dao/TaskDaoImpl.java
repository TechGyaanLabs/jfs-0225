package com.careerit.todo.dao;

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
        UUID id = task.getId();
        Task existingTask = tasks
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(existingTask != null){
            tasks.remove(existingTask);
            tasks.add(task);
            log.info("Task with id {} updated successfully", id);
            return task;
        } else {
            log.error("Task with id {} not found", id);
            return null;
        }
    }

    @Override
    public Task selectById(String id) {
        return null;
    }

    @Override
    public boolean deleteTask(UUID id) {
        return tasks
                .removeIf(task -> task.getId().equals(id));
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
        return tasks
                .stream()
                .filter(task -> task.getStatus() == Status.ARCHIVED)
                .toList();
    }

    @Override
    public List<Task>  search(String title,boolean flag) {
        if(title == null){
            return selectActiveTasks();
        } else {
            return selectActiveTasks()
                    .stream()
                    .filter(task -> task.getTitle().toLowerCase().contains(title!=null ? title.toLowerCase() : ""))
                    .toList();
        }
    }
    @Override
    public List<Task> addAllTasks(List<Task> tasks) {
        this.tasks.addAll(tasks);
        return tasks;
    }

    @Override
    public Task updateStatus(UUID id, Status status) {
        return null;
    }
}
