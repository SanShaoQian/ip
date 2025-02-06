package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

/**
 * Command to display a goodbye to the user
 */
public class ByeCommand extends Command {
    @Override
    public String execute(TaskManager tm, Storage storage) {
        return "bye bye";
    }
}