package stonks.task;

/**
 * A type of task
 * Contains a description only
 */
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileFormat() {
        return String.format("T | %d | %s", this.isDone ? 1:0, this.description);
    }
}
