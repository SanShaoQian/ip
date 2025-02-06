package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;

/**
 * Displays list of tasks stored
 */
public class ListCommand extends Command {
    @Override
    public String execute(TaskManager tm, Storage storage) {
        return "     Here are the tasks in your list:\n" + tm;
    }
}
