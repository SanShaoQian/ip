package stonks.command;

import stonks.storage.Storage;
import stonks.task.TaskManager;
import stonks.ui.Ui;

public class ByeCommand extends Command {
    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}