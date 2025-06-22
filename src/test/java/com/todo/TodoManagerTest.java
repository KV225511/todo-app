package com.todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TodoManagerTest {

    @Test
    void testAddValidTask() {
        TodoManager manager = new TodoManager();
        manager.addTask("Buy milk");
        assertEquals(1, manager.getTasks().size());
        assertTrue(manager.getTasks().contains("Buy milk"));
    }

    @Test
    void testAddEmptyTaskThrowsException() {
        TodoManager manager = new TodoManager();
        assertThrows(IllegalArgumentException.class, () -> manager.addTask(""));
        assertThrows(IllegalArgumentException.class, () -> manager.addTask("   "));
        assertThrows(IllegalArgumentException.class, () -> manager.addTask(null));
    }

    @Test
    void testRemoveExistingTask() {
        TodoManager manager = new TodoManager();
        manager.addTask("Finish project");
        boolean result = manager.removeTask("Finish project");
        assertTrue(result);
        assertEquals(0, manager.getTasks().size());
    }

    @Test
    void testRemoveNonexistentTask() {
        TodoManager manager = new TodoManager();
        manager.addTask("Learn Kubernetes");
        boolean result = manager.removeTask("Go jogging");
        assertFalse(result);
        assertEquals(1, manager.getTasks().size());
    }

    @Test
    void testGetTasksReturnsCopy() {
        TodoManager manager = new TodoManager();
        manager.addTask("Study DevOps");

        List<String> copy = manager.getTasks();
        copy.clear();  // modify the copy

        // Original list should remain unchanged
        assertEquals(1, manager.getTasks().size());
    }
}

