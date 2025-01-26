package stonks.parser;

import org.junit.jupiter.api.Test;
import stonks.command.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void testParser() {
        Parser p = new Parser();
        Command c = p.parse("bye");
        assertEquals(c instanceof ByeCommand, true);
        c = p.parse("list");
        assertEquals(c instanceof ListCommand, true);
        c = p.parse("mark 1");
        assertEquals(c instanceof MarkCommand, true);
        c = p.parse("unmark 2");
        assertEquals(c instanceof UnmarkCommand, true);
        c = p.parse("todo test");
        assertEquals(c instanceof AddCommand, true);
        c = p.parse("deadline test /by 2025-04-01");
        assertEquals(c instanceof AddCommand, true);
        c = p.parse("event test /from 2025-04-02 /to 2024-04-03");
        assertEquals(c instanceof AddCommand, true);
        c = p.parse("delete 1");
        assertEquals(c instanceof DeleteCommand, true);
        c = p.parse("test test test");
        assertEquals(c instanceof ErrorCommand, true);
        c = p.parse("event test test test");
        assertEquals(c instanceof ErrorCommand, true);
        c = p.parse("deadline test test test");
        assertEquals(c instanceof ErrorCommand, true);
    }
}
