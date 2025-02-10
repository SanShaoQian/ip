package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;

/**
 * Displays an error message
 */
public class ErrorCommand extends Command {
    private final String message;

    public ErrorCommand(String message) {
        this.message = message;
    }

    @Override
    public String execute(TaskManager tm, Storage storage) {
        return (message);
    }
}