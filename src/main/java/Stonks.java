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
        List<String> list = new ArrayList<>();
        while (true) {
            input = scanner.nextLine();
            if (input.equals("bye")) break;
            if (input.equals("list")) {
                System.out.print(separator);
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(String.format("     %d. %s", i + 1, list.get(i)));
                }
                System.out.print(separator);
            }
            else {
                list.add(input);
                System.out.print(String.format("%s     added: %s\n%s", separator, input, separator));
            }
        }
        System.out.println(separator + exit + separator);
        scanner.close();
    }
}