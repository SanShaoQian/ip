package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

/**
 * Displays an error message
 */
public class ErrorCommand extends Command {
    private final String message;

    public ErrorCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showMessage(message);
    }
}