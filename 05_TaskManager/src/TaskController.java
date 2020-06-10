import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TaskController {
    private static int taskNumber = 1;

    public void addTask() throws IOException {
        Task task = new Task(taskNumber);
        task = TaskUtilities.createNewTaskDialog(task);
        task.setState(1); //Open
        TaskManager.addTaskToTasks(task);

    }

    public void showTaskByNumber() throws IOException {
        TaskUtilities.showTaskByNumber();
    }

    public void editTaskByNumber() throws IOException {
        TaskUtilities.editTaskByNumber();
    }

    public void showAllTasks() {
        TaskUtilities.displayTaskList(TaskManager.getInstance().getTasks());
    }

    public static void deleteTask() throws IOException {
        TaskUtilities.deleteTaskByNumber();

    }

    public static void increaseTaskNumber() {
        taskNumber++;
    }

    public static Task getTaskByNumber(int number) {

        //To find a specific value th new Java 8 syntax is used. It's possible to filter by any values with a stream().filter() call
        return TaskManager
                .getInstance()
                .getTasks()
                .stream()
                .filter(t -> t.getNumber() == number)
                .findAny()
                .orElse(null);
    }
}


