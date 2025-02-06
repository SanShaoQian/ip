package stonks.command;

import stonks.storage.Storage;
import stonks.task.Task;
import stonks.task.TaskManager;
import stonks.ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String searchString;

    public FindCommand(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public String execute(TaskManager tm, Storage storage) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task i: tm.getTasks()) {
            if (i.contains(searchString)) {
                tasks.add(i);
            }
        }
        return "     Here are the matching tasks in your list:\n" + new TaskManager(tasks);
    }
}