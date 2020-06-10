import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TaskUtilities {


    /**
     *
     * @return
     * @throws IOException
     */
    public static int showMainMenuDialog() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> mainMenuDialogEntries = new ArrayList<>();
        mainMenuDialogEntries.add(Messages.MENU_ENTRY_ADD_TASK.getMessage());
        mainMenuDialogEntries.add(Messages.MENU_ENTRY_SHOW_TASK.getMessage());
        mainMenuDialogEntries.add(Messages.MENU_ENTRY_EDIT_TASK.getMessage());
        mainMenuDialogEntries.add(Messages.MENU_ENTRY_DELETE_TASK.getMessage());
        mainMenuDialogEntries.add(Messages.MENU_ENTRY_SHOW_ALL_TASKS.getMessage());
        mainMenuDialogEntries.add(Messages.MENU_ENTRY_EXIT.getMessage());
        displayArrayEntries(mainMenuDialogEntries);
        System.out.println(Messages.WELCOME.getMessage());

        return Integer.parseInt(reader.readLine());
    }

    /**
     *
     * @param task
     * @return
     * @throws IOException
     */
    public static Task createNewTaskDialog(Task task) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("%s: ", Messages.SHORT_DESCRIPTION.getMessage());
        task.setShortDescription(reader.readLine());

        System.out.printf("%s: ", Messages.DESCRIPTION.getMessage());
        task.setDescription(reader.readLine());

        System.out.printf("%s: ", Messages.PRIORITY.getMessage());
        task.setPriority(Integer.parseInt(reader.readLine()));

        return task;
    }

    /**
     *
     * @throws IOException
     */
    public static void showTaskByNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Messages.SHOW_TASK_DIALOG_QUESTION1.getMessage());
        TaskUtilities.displayTaskList(TaskManager.getInstance().getTasks());
        System.out.println(Messages.SHOW_TASK_DIALOG_QUESTION2.getMessage());
        int number = Integer.parseInt(reader.readLine());
        Task task = TaskController.getTaskByNumber(number);
        displayTaskDetails(task);
    }

    public static  void editTaskByNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Messages.EDIT_TASK_DIALOG_QUESTION1.getMessage());
        TaskUtilities.displayTaskList(TaskManager.getInstance().getTasks());
        System.out.println(Messages.EDIT_TASK_DIALOG_QUESTION2.getMessage());
        int number = Integer.parseInt(reader.readLine());
        Task task = TaskController.getTaskByNumber(number);

        System.out.printf("%s (%s): ", Messages.SHORT_DESCRIPTION.getMessage(), task.getShortDescription());
        task.setShortDescription(reader.readLine());

        System.out.printf("%s (%s): ", Messages.DESCRIPTION.getMessage(), task.getDescription());
        task.setDescription(reader.readLine());

        System.out.printf("%s (%s): ", Messages.STATE.getMessage(), task.getState());
        task.setState(Integer.parseInt(reader.readLine()));

        System.out.printf("%s (%s): ", Messages.PRIORITY.getMessage(), task.getPriority());
        task.setPriority(Integer.parseInt(reader.readLine()));

        System.out.println(Messages.EDIT_TASK_DIALOG_SUCCESS.getMessage());
        displayTaskDetails(task);
    }

    /**
     *
     * @throws IOException
     */
    public static void deleteTaskByNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Messages.DELETE_TASK_DIALOG_QUESTION1.getMessage());
        TaskUtilities.displayTaskList(TaskManager.getInstance().getTasks());
        System.out.println(Messages.DELETE_TASK_DIALOG_QUESTION2.getMessage());
        int number = Integer.parseInt(reader.readLine());
        Task task = TaskController.getTaskByNumber(number);
        TaskManager
                .getInstance()
                .getTasks()
                .remove(task);
        System.out.printf(Messages.DELETE_TASK_DIALOG_SUCCESS.getMessage(), number);
    }


    /**
     *
     * @param entries
     */
    public static void displayArrayEntries(ArrayList entries) {
        entries.forEach((entry) -> {
            System.out.printf("|%-2d- %-30s|", (entries.indexOf(entry) + 1), entry);
            System.out.println();

        });
    }

    public static void displayTaskDetails(Task task) {
        //number, short Description, description, state, priority
        System.out.printf("|%10d|%10s|%10s|%10s|%10s|", task.getNumber(), task.getShortDescription(), task.getDescription(), task.getState(), task.getPriority());
    }

    public static void displayTaskList(ArrayList<Task> taskList) {
        taskList.forEach((Task task) -> {
                    System.out.printf("|%010d|%10s|%10s|%10s|\n", task.getNumber(), task.getShortDescription(), task.getState(), task.getPriority());
                });
    }



}
