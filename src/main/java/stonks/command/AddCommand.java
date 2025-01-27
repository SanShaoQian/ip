package stonks.command;

import stonks.storage.Storage;
import stonks.task.Task;
import stonks.task.TaskManager;
import stonks.ui.Ui;

public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        tm.addTask(task);
        ui.showMessage("     Got it. I've added this task:\n"
                + "       " + task
                + String.format("\n     Now you have %d tasks in the list.", tm.size())
        );
        storage.save(tm.getTasks());
    }
}