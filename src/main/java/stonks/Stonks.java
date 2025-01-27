package stonks;

import stonks.storage.Storage;
import stonks.ui.Ui;
import stonks.command.ByeCommand;
import stonks.command.Command;
import stonks.task.TaskManager;
import stonks.parser.Parser;

public class Stonks {
    private Storage storage;
    private TaskManager tm;
    private Ui ui;

    public Stonks(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tm = new TaskManager(storage.load());
    }

    public void run() {
        ui.showGreeting();
        boolean done = false;
        while (!done) {
            String input = ui.readCommand();
            Command command = Parser.parse(input);
            command.execute(tm, ui, storage);
            done = command instanceof ByeCommand;
        }
    }

    public static void main(String[] args) {
        new Stonks("./data/stonks.txt").run();
    }
}