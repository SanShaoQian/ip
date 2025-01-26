import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskManager {
    private String filepath;
    private ArrayList<Task> tasks;

    public TaskManager(String filepath) {
        this.filepath = filepath;
        this.tasks = new ArrayList<>();
    }

    private Task stringToTask(String input) {
        if (input.startsWith("todo")) {
            String regex = "^\\s*(\\w+)\\s+(.*?)\\s*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) return new Todo(matcher.group(2));
            else {
                System.out.println("     OHNOOOO, a todo should have a description");
            }
        }
        else if (input.startsWith("deadline")) {
            String regex = "^\\s*(\\w+)\\s+(.*?)\\s+/by\\s+(.+)\\s*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) return new Deadline(matcher.group(2), matcher.group(3));
            else {
                System.out.println("     OHNOOOO, a deadline should have a description and deadline");
            }
        }
        else if (input.startsWith("event")) {
            String regex = "^\\s*(\\w+)\\s+(.*?)\\s+/from\\s+(.+?)\\s+/to\\s+(.+)\\s*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) return new Event(matcher.group(2), matcher.group(3), matcher.group(4));
            else {
                System.out.println("     OHNOOOO, an event should have a description, start and end");
            }
        }
        return null;
    }

    public Task addTask(String input) {
        Task task = stringToTask(input);
        if (task == null) return null;
        tasks.add(task);
        saveTasksToFile();
        return task;
    }

    private void saveTasksToFile() {
        Path path = Paths.get(this.filepath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Error initializing data file: " + e.getMessage());
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filepath))) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            output.append(String.format("     %d. %s\n", i + 1, tasks.get(i).toString()));
        }
        return output.toString();
    }

    public Task mark(int index) {
        this.tasks.get(index).markDone();;
        saveTasksToFile();
        return this.tasks.get(index);
    }

    public Task unmark(int index) {
        this.tasks.get(index).markNotDone();
        saveTasksToFile();
        return this.tasks.get(index);
    }

    public int size() {
        return this.tasks.size();
    }

    public Task deleteTask(int index) {
        Task task = this.tasks.get(index);
        this.tasks.remove(index);
        this.saveTasksToFile();
        return task;
    }
}
