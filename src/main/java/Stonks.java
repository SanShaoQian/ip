import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stonks {
    public static void main(String[] args) {
        String greeting = "     Hello! I'm Stonks\n" +
                "     What can I do for you?\n" ;
        String separator = "    ____________________________________________________________\n";
        String exit = "     Bye. Hope to see you again soon!\n" ;
        System.out.println(separator + greeting + separator);

        Scanner scanner = new Scanner(System.in);
        String input;
        String[] inputs;
        List<Task> list = new ArrayList<>();
        while (true) {
            input = scanner.nextLine();
            inputs = input.split(" ");
            if (inputs[0].equals("bye")) break;
            else if (inputs[0].equals("list")) {
                System.out.print(separator);
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(String.format("     %d. %s", i + 1, list.get(i).toString()));
                }
                System.out.print(separator);
            }
            else if (inputs[0].equals("mark")) {
                int index = Integer.parseInt(inputs[1]) - 1;
                System.out.print(separator);
                System.out.println("     Nice! I've marked this task as done:");
                list.get(index).markDone();
                System.out.println("       " + list.get(index).toString());
                System.out.print(separator);
            }
            else if (inputs[0].equals("unmark")) {
                int index = Integer.parseInt(inputs[1]) - 1;
                System.out.print(separator);
                System.out.println("     OK, I've marked this task as not done yet:");
                list.get(index).markNotDone();
                System.out.println("       " + list.get(index).toString());
                System.out.print(separator);
            }
            else if (inputs[0].equals("todo") || inputs[0].equals("deadline") || inputs[0].equals("event")) {
                System.out.print(separator);
                System.out.println("     Got it. I've added this task:");
                Task task = new Task("");
                if (inputs[0].equals("todo")) {
                    String regex = "^\\s*(\\w+)\\s+(.*?)\\s*$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.matches()) task = new Todo(matcher.group(2));
                }
                else if (inputs[0].equals("deadline")) {
                    String regex = "^\\s*(\\w+)\\s+(.*?)\\s+/by\\s+(.+)\\s*$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.matches()) task = new Deadline(matcher.group(2), matcher.group(3));
                }
                else if (inputs[0].equals("event")) {
                    String regex = "^\\s*(\\w+)\\s+(.*?)\\s+/from\\s+(.+?)\\s+/to\\s+(.+)\\s*$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.matches()) task = new Event(matcher.group(2), matcher.group(3), matcher.group(4));
                }
                list.add(task);
                System.out.println("       " + task);
                System.out.println(String.format("     Now you have %d tasks in the list.", list.size()));
                System.out.print(separator);
            }
        }
        System.out.println(separator + exit + separator);
        scanner.close();
    }
}