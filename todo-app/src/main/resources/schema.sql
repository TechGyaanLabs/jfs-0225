CREATE TABLE IF NOT EXISTS task (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    due_date DATE,
    priority VARCHAR(20),
    status VARCHAR(20)
);
