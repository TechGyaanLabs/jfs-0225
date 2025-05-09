package com.careerit.todo.service;

import com.careerit.todo.dao.TaskDao;
import com.careerit.todo.domain.Priority;
import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j

public class TaskServiceImpl implements TaskService {


    private final TaskDao taskDao;

    public TaskServiceImpl(@Qualifier("taskDaoDBImpl") TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    @Override
    public Task createTask(Task task) {
        validateAndSetDefaultValues(task);
        Task newTask = taskDao.insertTask(task);
        log.info("Task with title {} created successfully", task.getTitle());
        return newTask;
    }

    @Override
    public Task updateTask(Task task) {
        Assert.notNull(task, "Task cannot be null");
        Assert.notNull(task.getId(), "Task id cannot be null");
        Assert.notNull(task.getTitle(), "Task title cannot be null");
        if(task.getPriority() == null){
            task.setPriority(Priority.LOW);
        }
        if(task.getStatus() == null){
            task.setStatus(Status.PENDING);
        }
        if(task.getDueDate() == null){
            task.setDueDate(LocalDate.now().plusDays(5));
        }
        Task updatedTask = taskDao.updateTask(task);
        log.info("Task with title {} updated successfully", task.getTitle());
        return updatedTask;
    }

    @Override
    public Task getTaskById(String id) {
        return null;
    }

    @Override
    public boolean deleteTask(UUID id) {
        return taskDao.deleteTask(id);
    }

    @Override
    public List<Task> getAllActiveTasks() {
       log.info("Requesting for active tasks");
       List<Task> tasks = taskDao.selectActiveTasks();
       log.info("Total {} active tasks found", tasks.size());
       return tasks;
    }

    @Override
    public List<Task> getArchivedTasks() {
        List<Task> tasks = taskDao.selectArchivedTasks();
        log.info("Total {} archived tasks found", tasks.size());
        return tasks;
    }

    @Override
    public List<Task> search(String title, boolean flag) {
        log.info("Searching for tasks with title {} and flag {}", title, flag);
         if ((title == null || title.isEmpty()) ) {
            return taskDao.selectActiveTasks();
         }else {
            return taskDao.search(title,flag);
         }
    }

    @Override
    public List<Task> addAllTasks(List<Task> tasks) {
        log.info("Adding {} tasks", tasks.size());
        for(Task task : tasks){
            validateAndSetDefaultValues(task);
        }
        return taskDao.addAllTasks(tasks);
    }

    @Override
    public Task updateStatus(UUID id, Status status) {
        log.info("Updating status of task with id {} to {}", id, status);
        Task task = taskDao.updateStatus(id, status);
        log.info("Task with id {} updated successfully", id);
        return task;
    }

    private static void validateAndSetDefaultValues(Task task) {
        Assert.notNull(task, "Task cannot be null");
        Assert.notNull(task.getTitle(), "Task title cannot be null");
        if(task.getPriority() == null){
            task.setPriority(Priority.LOW);
        }
        if(task.getStatus() == null){
            task.setStatus(Status.PENDING);
        }
        if(task.getDueDate() == null){
            task.setDueDate(LocalDate.now().plusDays(5));
        }
    }
}
