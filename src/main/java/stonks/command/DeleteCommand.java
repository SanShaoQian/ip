package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showMessage("     Noted. I've removed this task:\n" + "       " +
                tm.deleteTask(index) +
                String.format("\n     Now you have %d tasks in the list.", tm.size())
        );
        storage.save(tm.getTasks());
    }
}
