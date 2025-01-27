package stonks.ui;

import java.util.Scanner;
import stonks.task.TaskManager;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        String SEPARATOR = "    ____________________________________________________________\n";
        System.out.print(SEPARATOR + message + "\n" + SEPARATOR);
    }

    public void showGreeting() {
        String greeting = "     Hello! I'm Stonks\n" +
                "     What can I do for you?" ;
        showMessage(greeting);
    }

    public void showGoodbye() {
        showMessage("     Bye. Hope to see you again soon!");
    }

    public void showList(TaskManager taskManager) {
        showMessage("     Here are the tasks in your list:\n" + taskManager);
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }
}
