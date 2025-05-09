package com.careerit.todo.api;

import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;
import com.careerit.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        Task updatedTask = taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable UUID id) {
        boolean res = taskService.deleteTask(id);
        String message = res ? "Task deleted successfully" : "Task not found";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/all-archived")
    public ResponseEntity<List<Task>> getArchivedTasks() {
        List<Task> tasks = taskService.getArchivedTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam(required = false) String title,@RequestParam(value = "flag",defaultValue = "false") boolean flag) {
        List<Task> tasks = taskService.search(title, flag);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<Task>> addAllTasks(@RequestBody List<Task> tasks) {
        List<Task> addedTasks = taskService.addAllTasks(tasks);
        return ResponseEntity.ok(addedTasks);
    }

    @PutMapping("/update-status/{id}/{status}")
    public ResponseEntity<Task> updateStatus(@PathVariable ("id") UUID id, @PathVariable ("status") Status status) {
           Task task = taskService.updateStatus(id, status);
           return ResponseEntity.ok(task);
    }

}
