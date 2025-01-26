import java.util.Scanner;

public class Ui {
    private final Scanner scanner;
    String separator = "    ____________________________________________________________\n";

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.print(separator + message + "\n" + separator);
    }

    public void showGreeting() {
        String greeting = "     Hello! I'm Stonks\n" +
                "     What can I do for you?" ;
        this.showMessage(greeting);
    }

    public void showGoodbye() {
        this.showMessage("     Bye. Hope to see you again soon!");
    }

    public void showList(TaskManager taskManager) {
        showMessage("     Here are the tasks in your list:\n" + taskManager);
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }
}
