package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

/**
 * Mark required task as complete
 */
public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        assert index >= 0 : "Index cannot be negative";
        this.index = index;
    }

    @Override
    public String execute(TaskManager tm, Storage storage) {
        assert index < tm.getTasks().size() : "Index out of bounds";
        tm.mark(index);
        storage.save(tm.getTasks());
        return ("     Nice! I've marked this task as done:\n"
                + "       " + tm.mark(index));
    }
}