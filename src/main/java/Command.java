abstract class Command {
    public abstract void execute(TaskManager tm, Ui ui, Storage storage);
}

class ByeCommand extends Command {
    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}

class ListCommand extends Command {
    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showList(tm);
    }
}

class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showMessage("     Nice! I've marked this task as done:\n" + "       " + tm.mark(index));
        storage.save(tm.getTasks());
    }
}

class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showMessage("     OK, I've marked this task as not done yet:\n" + "       " + tm.unmark(index));
        storage.save(tm.getTasks());
    }
}

class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        tm.addTask(task);
        ui.showMessage("     Got it. I've added this task:\n" +
                "       " + task +
                String.format("\n     Now you have %d tasks in the list.", tm.size())
        );
        storage.save(tm.getTasks());
    }
}

class DeleteCommand extends Command {
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

class ErrorCommand extends Command {
    private final String message;

    public ErrorCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(TaskManager tm, Ui ui, Storage storage) {
        ui.showMessage(message);
    }
}
