package stonks.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate start;
    private LocalDate end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = LocalDate.parse(start);
        this.end = LocalDate.parse(end);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return String.format("[E]%s (from: %s to: %s)",
                super.toString(), start.format(formatter), end.format(formatter));
    }

    @Override
    public String toFileFormat() {
        return String.format("E | %d | %s | %s | %s", this.isDone ? 1:0,
                this.description, this.start, this.end);
    }
}
