package stonks.ui;

import java.util.Scanner;
import stonks.task.TaskManager;

/**
 * Deals with interactions with the user
 */
public class Ui {
    private static final String SEPARATOR = "    ____________________________________________________________\n";
    /**
     * Prints message given with separating lines
     * @param message text to be displayed
     */
    public void showMessage(String message) {
        System.out.print(SEPARATOR + message + "\n" + SEPARATOR);
    }

    /**
     * Greets user when chatbot is opened
     */
    public void showGreeting() {
        String greeting = "     Hello! I'm Stonks\n" +
                "     What can I do for you?" ;
        showMessage(greeting);
    }

    /**
     * Says goodbye to user when chatbot is closed
     */
    public void showGoodbye() {
        showMessage("     Bye. Hope to see you again soon!");
    }

    /**
     * Shows list of all current tasks
     * @param taskManager collation of tasks
     */
    public void showList(TaskManager taskManager) {
        showMessage("     Here are the tasks in your list:\n" + taskManager);
    }

    /**
     * Display all tasks with description containing string provided
     * @param taskManager contains all matching tasks
     */
    public void showMatchingList(TaskManager taskManager) {
        showMessage("     Here are the matching tasks in your list:\n" + taskManager);
    }

//    /**
//     * Takes in user input
//     * @return string provided by user
//     */
//    public String readCommand() {
//        return scanner.nextLine().trim();
//    }
}
