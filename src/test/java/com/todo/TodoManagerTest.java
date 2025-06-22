package com.todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TodoManagerTest {

    @Test
    void testAddTask() {
        TodoManager manager = new TodoManager();
        manager.addTask("Learn Docker");
        assertEquals(1, manager.countTasks());
        assertTrue(manager.getTasks().contains("Learn Docker"));
    }

    @Test
    void testRemoveTask() {
        TodoManager manager = new TodoManager();
        manager.addTask("Clean desk");
        assertTrue(manager.removeTask("Clean desk"));
        assertEquals(0, manager.countTasks());
    }

    @Test
    void testEmptyTaskThrowsException() {
        TodoManager manager = new TodoManager();
        assertThrows(IllegalArgumentException.class, () -> manager.addTask("  "));
    }

    @Test
    void testGetTasksReturnsCopy() {
        TodoManager manager = new TodoManager();
        manager.addTask("Refactor code");
        List<String> tasks = manager.getTasks();
        tasks.clear();
        assertEquals(1, manager.countTasks());  // internal list is safe
    }
}
