package stonks.task;

public class Deadline extends Task {
    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), deadline);
    }

    @Override
    public String toFileFormat() {
        return String.format("D | %d | %s | %s", this.isDone ? 1:0, this.description, this.deadline);
    }
}
