import java.io.IOException;
import java.util.ArrayList;

public class TaskManager {
    private static final TaskManager tm = new TaskManager();
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static boolean running = true;

    private TaskManager() {
        System.out.println(Messages.START.getMessage());
    }

    public static TaskManager getInstance() {
        return tm;
    }

    public static void addTaskToTasks (Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void run () throws IOException {
        TaskController tc = new TaskController();
        if (running) {
            switch (TaskUtilities.showMainMenuDialog()) {
                case 1:
                    tc.addTask();
                    break;
                case 2:
                    tc.showTaskByNumber();
                    break;
                case 3:
                    tc.editTaskByNumber();
                    break;
                case 4:
                    tc.deleteTask();
                    break;
                case 5:
                    tc.showAllTasks();
                    break;
                case 6:
                    System.out.println(Messages.ENDE.getMessage());
                    System.exit(1);
                    break;
                default:
                    System.out.println(Messages.WARNING_WRON_MENU_ENTRY.getMessage());
                    break;
            }
            run();
        } else {
            System.exit(1);
        }

    }



}
