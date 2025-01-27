package stonks.command;

import stonks.task.TaskManager;
import stonks.ui.Ui;
import stonks.storage.Storage;

/**
 * Action to be completed according to user input
 */
public abstract class Command {
    /**
     * Executes the command depending on the user input
     * @param tm taskManager to be altered
     * @param ui Ui for processing user input and output
     * @param storage updates hard disc if tasks are altered
     */
    public abstract void execute(TaskManager tm, Ui ui, Storage storage);
}