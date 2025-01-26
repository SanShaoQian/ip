import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static Command parse(String input) {
        String[] parts = input.split(" ", 2);
        String commandWord = parts[0];

        switch (commandWord) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(Integer.parseInt(parts[1]) - 1);
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(parts[1]) - 1);
            case "todo":
                String regex = "^\\s*(\\w+)\\s+(.*?)\\s*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);
                if (matcher.matches()) return new AddCommand(new Todo(matcher.group(2)));
                else {
                    return new ErrorCommand("     OHNOOOO, a todo should have a description");
                }
            case "deadline":
                regex = "^\\s*(\\w+)\\s+(.*?)\\s+/by\\s+(.+)\\s*$";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(input);
                if (matcher.matches()) return new AddCommand(new Deadline(matcher.group(2), matcher.group(3)));
                else {
                    return new ErrorCommand("     OHNOOOO, a deadline should have a description and deadline");
                }
            case "event":
                regex = "^\\s*(\\w+)\\s+(.*?)\\s+/from\\s+(.+?)\\s+/to\\s+(.+)\\s*$";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(input);
                if (matcher.matches()) return new AddCommand(new Event(matcher.group(2), matcher.group(3), matcher.group(4)));
                else return new ErrorCommand("     OHNOOOO, an event should have a description, start and end");
            case "delete":
                return new DeleteCommand(Integer.parseInt(parts[1]) - 1);
            default:
                return new ErrorCommand("     Sorry, I don't know what that means.");
        }
    }
}
