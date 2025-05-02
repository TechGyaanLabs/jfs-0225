package com.careerit.todo.service;

import com.careerit.todo.dao.TaskDao;
import com.careerit.todo.domain.Priority;
import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    @Override
    public Task createTask(Task task) {
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
        Task newTask = taskDao.insertTask(task);
        log.info("Task with title {} created successfully", task.getTitle());
        return newTask;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public Task getTaskById(String id) {
        return null;
    }

    @Override
    public boolean deleteTask(String id) {
        return false;
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
        return List.of();
    }

    @Override
    public List<Task> search(String title, Priority priority, Status status) {
        return List.of();
    }
}
