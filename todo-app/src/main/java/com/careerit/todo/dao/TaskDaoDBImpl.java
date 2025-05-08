package com.careerit.todo.dao;

import com.careerit.todo.domain.Priority;
import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Slf4j
@Qualifier("taskDaoDBImpl")
public class TaskDaoDBImpl implements TaskDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_TASK = """
            INSERT INTO task (id, title, description, due_date, priority, status)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    private static final String UPDATE_TASK = """
            UPDATE task
            SET title = ?, description = ?, due_date = ?, priority = ?, status = ?
            WHERE id = ?
            """;

    private static final String SELECT_BY_ID = """
            SELECT id, title, description, due_date, priority, status
            FROM task
            WHERE id = ?
            """;

    private static final String DELETE_TASK = """
            DELETE FROM task
            WHERE id = ?
            """;

    private static final String GET_ARCHIVED_TASKS = """
            SELECT id, title, description, due_date, priority, status
            FROM task
            WHERE status = 'ARCHIVED'
            """;


    @Override
    public Task insertTask(Task task) {
        UUID id = UUID.randomUUID();
        task.setId(id);
        jdbcTemplate.update(INSERT_TASK,
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority().name(),
                task.getStatus().name());
        log.info("Task inserted with id: {}", id);
        return task;
    }

    @Override
    public Task updateTask(Task task) {
        int rows = jdbcTemplate.update(UPDATE_TASK,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority().name(),
                task.getStatus().name(),
                task.getId());
        if (rows > 0) {
            log.info("Task with id {} updated successfully", task.getId());
            return task;
        } else {
            log.error("Task with id {} not found", task.getId());
            return null;
        }
    }

    @Override
    public Task selectById(String id) {
        try {
            UUID taskId = UUID.fromString(id);
            return jdbcTemplate.queryForObject(SELECT_BY_ID,
                    TaskQueriesUtil.getTaskRowMapper(),
                    taskId);
        } catch (Exception e) {
            log.error("Error finding task with id {}: {}", id, e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteTask(UUID id) {
        int rows = jdbcTemplate.update(DELETE_TASK, id);
        boolean deleted = rows > 0;
        if (deleted) {
            log.info("Task with id {} deleted successfully", id);
        } else {
            log.error("Task with id {} not found", id);
        }
        return deleted;
    }

    @Override
    public List<Task> selectActiveTasks() {
        List<Task> result = jdbcTemplate.query(TaskQueriesUtil.GET_ACTIVE_TASKS, TaskQueriesUtil.getTaskRowMapper());
        log.info("Active tasks fetched from DB: {}", result);
        return result;
    }

    @Override
    public List<Task> selectArchivedTasks() {
        List<Task> result = jdbcTemplate.query(GET_ARCHIVED_TASKS, TaskQueriesUtil.getTaskRowMapper());
        log.info("Archived tasks fetched from DB: {}", result);
        return result;
    }

    private static final String SEARCH_TASKS = """
            SELECT id, title, description, due_date, priority, status
            FROM task
            WHERE (LOWER(title) LIKE LOWER(?) OR ? IS NULL)
                                                     AND (priority = ?)
                                                     AND (status = ?)
            """;

    @Override
    public List<Task> search(String title, Priority priority, Status status) {
        if(title == null && priority == null && status == null) {
            return selectActiveTasks();
        }else{
            if(title != null) {
                title = "%" + title + "%";
            }
            if(priority != null) {
                priority = Priority.valueOf(priority.name());
            }
            if(status != null) {
                status = Status.valueOf(status.name());
            }

            return jdbcTemplate.query(SEARCH_TASKS,
                    TaskQueriesUtil.getTaskRowMapper(),
                    title,
                    title,
                    priority != null ? priority.name() : null,
                    status != null ? status.name() : null);
        }
    }

    @Override
    public List<Task> addAllTasks(List<Task> tasks) {
        for (Task task : tasks) {
            insertTask(task);
        }
        log.info("Added {} tasks", tasks.size());
        return tasks;
    }

    @Override
    public Task updateStatus(UUID id, Status status) {
        String sql = "UPDATE task SET status = ? WHERE id = ?";
        int rows = jdbcTemplate.update(sql, status.name(), id);
        if (rows > 0) {
            log.info("Task with id {} updated to status {}", id, status);
            return selectById(id.toString());
        } else {
            log.error("Task with id {} not found", id);
            return null;
        }
    }
}
