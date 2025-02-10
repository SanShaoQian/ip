package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

/**
 * Mark required task as incomplete
 */
public class UnmarkCommand extends Command {
    private final int index;
    private static final String MESSAGE = "     OK, I've marked this task as not done yet:\n       ";

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskManager tm, Storage storage) {
        tm.unmark(index);
        storage.save(tm.getTasks());
        return (MESSAGE + tm.unmark(index));
    }
}
