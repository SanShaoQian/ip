package stonks;

import stonks.storage.Storage;
import stonks.task.*;
import stonks.ui.Ui;
import stonks.command.*;
import stonks.parser.Parser;

/**
 * Chatbot named Stonks to store a todo-list
 */
public class Stonks {
    private Storage storage;
    private TaskManager tm;
    private Ui ui;

    public Stonks(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tm = new TaskManager(storage.load());
    }

    /**
     * Processes user input and alters a todo-list accordingly
     */
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

    /**
     * Processes user input and alters a todo-list accordingly
     */
    public static void main(String[] args) {
        new Stonks("./data/stonks.txt").run();
    }
}