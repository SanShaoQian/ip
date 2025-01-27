package stonks.command;

import stonks.task.TaskManager;
import stonks.ui.Ui;
import stonks.storage.Storage;

public abstract class Command {
    public abstract void execute(TaskManager tm, Ui ui, Storage storage);
}