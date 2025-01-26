import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Storage {
    String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<Task> load() {
        Path path = Paths.get(this.filepath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Error initializing data file: " + e.getMessage());
                return null;
            }
        }
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length < 3) continue;
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];
                Task task = switch (type) {
                    case "T" -> new Todo(description);
                    case "D" -> new Deadline(description, parts.length > 3 ? parts[3] : null);
                    case "E" -> new Event(description, parts.length > 3 ? parts[3] : null, parts.length > 4 ? parts[4] : null);
                    default -> null;
                };
                if (task != null) {
                    if (isDone) {
                        task.markDone();
                    }
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading data file: " + e.getMessage());
        }
        return tasks;
    }

    public void save(ArrayList<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filepath))) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    public void clearDataFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filepath))) {
            writer.write("");
        } catch (IOException e) {
            System.out.println("Error clearing data file: " + e.getMessage());
        }
    }
}
