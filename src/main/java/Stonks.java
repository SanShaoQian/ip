import java.util.Scanner;

public class Stonks {
    public static void main(String[] args) {
        String greeting = "     Hello! I'm Stonks\n" +
                "     What can I do for you?\n" ;
        String separator = "    ____________________________________________________________\n";
        String exit = "     Bye. Hope to see you again soon!\n" ;
        System.out.println(separator + greeting + separator);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("bye")) {
            System.out.println(separator + "     " + input + "\n" + separator);
            input = scanner.nextLine();
        }

        System.out.println(separator + exit + separator);
        scanner.close();

    }
}