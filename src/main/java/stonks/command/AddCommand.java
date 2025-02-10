package stonks.command;

import stonks.storage.Storage;
import stonks.task.Task;
import stonks.task.TaskManager;

/**
 * Command which adds a task into the taskManager
 */
public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public String execute(TaskManager tm, Storage storage) {
        tm.addTask(task);
        assert tm.size() > 0 : "TaskManager should have at least 1 task";
        storage.save(tm.getTasks());
        return "     Got it. I've added this task:\n"
                + "       " + task
                + String.format("\n     Now you have %d tasks in the list.", tm.size());
    }
}