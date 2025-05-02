package com.careerit.todo.api;

import com.careerit.todo.domain.Task;
import com.careerit.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getActiveTasks() {
        List<Task> tasks = taskService.getAllActiveTasks();
        return ResponseEntity.ok(tasks);
    }

}
