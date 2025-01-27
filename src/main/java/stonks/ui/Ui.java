package stonks.ui;

import java.util.Scanner;
import stonks.task.TaskManager;

/**
 * deals with interactions with the user
 */
public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * prints message given with separating lines
     * @param message text to be displayed
     */
    public void showMessage(String message) {
        String SEPARATOR = "    ____________________________________________________________\n";
        System.out.print(SEPARATOR + message + "\n" + SEPARATOR);
    }

    /**
     * greets user when chatbot is opened
     */
    public void showGreeting() {
        String greeting = "     Hello! I'm Stonks\n" +
                "     What can I do for you?" ;
        showMessage(greeting);
    }

    /**
     * says goodbye to user when chatbot is closed
     */
    public void showGoodbye() {
        showMessage("     Bye. Hope to see you again soon!");
    }

    /**
     * shows list of all current tasks
     * @param taskManager collation of tasks
     */
    public void showList(TaskManager taskManager) {
        showMessage("     Here are the tasks in your list:\n" + taskManager);
    }

    /**
     * takes in user input
     * @return string provided by user
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }
}
