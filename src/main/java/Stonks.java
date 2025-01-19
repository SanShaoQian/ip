import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stonks {
    public static void main(String[] args) {
        String greeting = "     Hello! I'm Stonks\n" +
                "     What can I do for you?\n" ;
        String separator = "    ____________________________________________________________\n";
        String exit = "     Bye. Hope to see you again soon!\n" ;
        System.out.println(separator + greeting + separator);

        Scanner scanner = new Scanner(System.in);
        String input;
        List<Task> list = new ArrayList<>();
        while (true) {
            input = scanner.nextLine();
            String[] in = input.split(" ");
            if (input.equals("bye")) break;
            else if (input.equals("list")) {
                System.out.print(separator);
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(String.format("     %d. %s", i + 1, list.get(i).toString()));
                }
                System.out.print(separator);
            }
            else if (in[0].equals("mark")) {
                int index = Integer.parseInt(in[1]) - 1;
                System.out.print(separator);
                System.out.println("     Nice! I've marked this task as done:");
                list.get(index).markDone();
                System.out.println("       " + list.get(index).toString());
                System.out.print(separator);
            }
            else if (in[0].equals("unmark")) {
                int index = Integer.parseInt(in[1]) - 1;
                System.out.print(separator);
                System.out.println("     OK, I've marked this task as not done yet:");
                list.get(index).markNotDone();
                System.out.println("       " + list.get(index).toString());
                System.out.print(separator);
            }
            else {
                list.add(new Task(input));
                System.out.print(String.format("%s     added: %s\n%s", separator, input, separator));
            }
        }
        System.out.println(separator + exit + separator);
        scanner.close();
    }
}