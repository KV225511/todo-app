package com.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoManager {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty");
        }
        tasks.add(task);
        System.out.println("✅ Task added: " + task);
    }

    public boolean removeTask(String task) {
        boolean removed = tasks.remove(task);
        if (removed) {
            System.out.println("🗑️ Task removed: " + task);
        } else {
            System.out.println("⚠️ Task not found: " + task);
        }
        return removed;
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks found.");
        } else {
            System.out.println("📝 Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TodoManager manager = new TodoManager();
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("===== 🧠 TODO MANAGER CLI =====");

        do {
            System.out.println("\nOptions:");
            System.out.println("1 - Add task");
            System.out.println("2 - Remove task");
            System.out.println("3 - View tasks");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter task to add: ");
                    String newTask = scanner.nextLine();
                    try {
                        manager.addTask(newTask);
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠️ Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Enter task to remove: ");
                    String taskToRemove = scanner.nextLine();
                    manager.removeTask(taskToRemove);
                    break;

                case "3":
                    manager.listTasks();
                    break;

                case "4":
                    System.out.println("👋 Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please enter 1-4.");
            }
        } while (!choice.equals("4"));

        scanner.close();
    }
}

