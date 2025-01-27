package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showMessage("     OK, I've marked this task as not done yet:\n"
                + "       " + tm.unmark(index));
        storage.save(tm.getTasks());
    }
}
