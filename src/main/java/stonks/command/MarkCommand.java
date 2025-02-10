package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

/**
 * Mark required task as complete
 */
public class MarkCommand extends Command {
    private final int index;
    private final String MESSAGE = "     Nice! I've marked this task as done:\n       ";

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskManager tm, Storage storage) {
        tm.mark(index);
        storage.save(tm.getTasks());
        return (MESSAGE + tm.mark(index));
    }
}