import java.util.Scanner;

public class Stonks {
    public static void main(String[] args) {
        String greeting = "     Hello! I'm Stonks\n" +
                "     What can I do for you?\n" ;
        String separator = "    ____________________________________________________________\n";
        System.out.print(separator + greeting + separator);

        Scanner scanner = new Scanner(System.in);
        String input;
        TaskManager tm = new TaskManager("./data/stonks.txt");
        while (true) {
            input = scanner.nextLine();
            System.out.print(separator);
            if (input.startsWith("bye")) {
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.print(separator);
                break;
            }
            else if (input.startsWith("list")) {
                System.out.println("     Here are the tasks in your list:");
                System.out.print(tm);
            }
            else if (input.startsWith("mark")) {
                String[] inputs = input.split(" ");
                int index = Integer.parseInt(inputs[1]) - 1;
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println("       " + tm.mark(index));
            }
            else if (input.startsWith("unmark")) {
                String[] inputs = input.split(" ");
                int index = Integer.parseInt(inputs[1]) - 1;
                System.out.println("     OK, I've marked this task as not done yet:");
                System.out.println("       " + tm.unmark(index));
            }
            else if (input.startsWith("todo") || input.startsWith("deadline") || input.startsWith("event")) {
                Task task = tm.addTask(input);
                if (task == null) {
                    System.out.print(separator);
                    continue;
                }
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task);
                System.out.println(String.format("     Now you have %d tasks in the list.", tm.size()));
            }
            else if (input.startsWith("delete")) {
                String[] inputs = input.split(" ");
                int index = Integer.parseInt(inputs[1]) - 1;
                System.out.println("     Noted. I've removed this task:");
                System.out.println("       " + tm.deleteTask(index));
                System.out.println(String.format("     Now you have %d tasks in the list.", tm.size()));
            }
            else {
                System.out.println("     Sorry, I don't know what that means.");
            }
            System.out.print(separator);
        }
        scanner.close();
    }
}