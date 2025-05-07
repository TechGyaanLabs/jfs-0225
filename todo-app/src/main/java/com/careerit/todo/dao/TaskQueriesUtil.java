package com.careerit.todo.dao;

import com.careerit.todo.domain.Priority;
import com.careerit.todo.domain.Status;
import com.careerit.todo.domain.Task;
import org.springframework.jdbc.core.RowMapper;

import java.util.UUID;

public class TaskQueriesUtil {

    public static final  String GET_ACTIVE_TASKS = """
        select
        	id,
        	title,
        	description,
        	description,
        	due_date,
        	priority,
        	status
        from
        	task
        where
        	status in('ACTIVE', 'PENDING')
       """;



    public static RowMapper<Task> getTaskRowMapper() {
        return (rs, rowNum) -> {
            Task task = new Task();
            task.setId(rs.getObject("id", UUID.class));
            task.setTitle(rs.getString("title"));
            task.setDescription(rs.getString("description"));
            task.setDueDate(rs.getDate("due_date").toLocalDate());
            task.setPriority(Priority.valueOf(rs.getString("priority")));
            task.setStatus(Status.valueOf(rs.getString("status")));
            return task;
        };
    }
}
