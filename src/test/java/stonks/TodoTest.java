package stonks.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void stringTest() {
        Todo todo = new Todo("test");
        assertEquals(todo.toString(), "[T][ ] test" );
    }

    @Test
    public void markTest() {
        Todo todo = new Todo("test");
        todo.markDone();
        assertEquals(todo.isDone, true);
        assertEquals(todo.toString(), "[T][X] test");
        todo.markNotDone();
        assertEquals(todo.isDone, false);
        assertEquals(todo.toString(), "[T][ ] test" );
    }
}
