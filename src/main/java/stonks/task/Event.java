package stonks.task;

public class Event extends Task {
    private String start;
    private String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), start, end);
    }

    @Override
    public String toFileFormat() {
        return String.format("E | %d | %s | %s | %s", this.isDone ? 1:0, this.description, this.start, this.end);
    }
}
