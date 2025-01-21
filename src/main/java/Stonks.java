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
        System.out.print(separator + greeting + separator);

        Scanner scanner = new Scanner(System.in);
        String input;
        String[] inputs;
        List<Task> list = new ArrayList<>();
        while (true) {
            input = scanner.nextLine();
            inputs = input.split(" ");
            System.out.print(separator);
            if (inputs[0].equals("bye")) {
                System.out.println(exit);
                System.out.print(separator);
                break;
            }
            else if (inputs[0].equals("list")) {
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(String.format("     %d. %s", i + 1, list.get(i).toString()));
                }
                System.out.print(separator);
            }
            else if (inputs[0].equals("mark")) {
                int index = Integer.parseInt(inputs[1]) - 1;
                System.out.println("     Nice! I've marked this task as done:");
                list.get(index).markDone();
                System.out.println("       " + list.get(index).toString());
                System.out.print(separator);
            }
            else if (inputs[0].equals("unmark")) {
                int index = Integer.parseInt(inputs[1]) - 1;
                System.out.println("     OK, I've marked this task as not done yet:");
                list.get(index).markNotDone();
                System.out.println("       " + list.get(index).toString());
                System.out.print(separator);
            }
            else if (inputs[0].equals("todo") || inputs[0].equals("deadline") || inputs[0].equals("event")) {
                Task task = new Task("");
                if (inputs[0].equals("todo")) {
                    String regex = "^\\s*(\\w+)\\s+(.*?)\\s*$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.matches()) task = new Todo(matcher.group(2));
                    else {
                        System.out.println("     OHNOOOO, a todo should have a description");
                        System.out.println(separator);
                        continue;
                    }
                }
                else if (inputs[0].equals("deadline")) {
                    String regex = "^\\s*(\\w+)\\s+(.*?)\\s+/by\\s+(.+)\\s*$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.matches()) task = new Deadline(matcher.group(2), matcher.group(3));
                    else {
                        System.out.println("     OHNOOOO, a deadline should have a description and deadline");
                        System.out.println(separator);
                        continue;
                    }
                }
                else if (inputs[0].equals("event")) {
                    String regex = "^\\s*(\\w+)\\s+(.*?)\\s+/from\\s+(.+?)\\s+/to\\s+(.+)\\s*$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.matches()) task = new Event(matcher.group(2), matcher.group(3), matcher.group(4));
                    else {
                        System.out.println("     OHNOOOO, an event should have a description, start and end");
                        System.out.println(separator);
                        continue;
                    }
                }
                list.add(task);
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task);
                System.out.println(String.format("     Now you have %d tasks in the list.", list.size()));
            }
            else if (inputs[0].equals("delete")) {
                int index = Integer.parseInt(inputs[1]) - 1;
                Task task = list.get(index);
                list.remove(index);
                System.out.println("     Noted. I've removed this task:");
                System.out.println("       " + task);
                System.out.println(String.format("     Now you have %d tasks in the list.", list.size()));
            }
            else {
                System.out.println("     Sorry, I don't know what that means.");
            }
            System.out.print(separator);
        }
        scanner.close();
    }
}