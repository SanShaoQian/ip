package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showMessage("     Nice! I've marked this task as done:\n" + "       " + tm.mark(index));
        storage.save(tm.getTasks());
    }
}