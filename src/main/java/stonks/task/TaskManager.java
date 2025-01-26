package stonks.task;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            if (i == tasks.size() - 1) {
                output.append(String.format("     %d. %s", i + 1, tasks.get(i).toString()));
            } else {
                output.append(String.format("     %d. %s\n", i + 1, tasks.get(i).toString()));
            }
        }
        return output.toString();
    }

    public Task mark(int index) {
        this.tasks.get(index).markDone();;
        return this.tasks.get(index);
    }

    public Task unmark(int index) {
        this.tasks.get(index).markNotDone();
        return this.tasks.get(index);
    }

    public int size() {
        return this.tasks.size();
    }

    public Task deleteTask(int index) {
        Task task = this.tasks.get(index);
        this.tasks.remove(index);
        return task;
    }
}
