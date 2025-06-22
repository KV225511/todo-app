package com.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoManager {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty");
        }
        tasks.add(task);
    }

    public boolean removeTask(String task) {
        return tasks.remove(task);
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    public int countTasks() {
        return tasks.size();
    }
}
