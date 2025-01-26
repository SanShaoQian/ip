package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

/**
 * Displays list of tasks stored
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showList(tm);
    }
}
