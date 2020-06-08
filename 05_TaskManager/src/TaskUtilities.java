import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskUtilities {

    public void showMainMenuDialog() {
        ArrayList<String> mainMenuDialogEntries = new ArrayList<>();
        mainMenuDialogEntries.add("Add Task");
        mainMenuDialogEntries.add("Show Task");
        mainMenuDialogEntries.add("Edit Task");
        mainMenuDialogEntries.add("Delete Task");
        displayArrayEntries(mainMenuDialogEntries);
        userInput();
    }

    public void showAddTaskDialog() {
        ArrayList<String> addTaskDialogEntries = new ArrayList<>();
        addTaskDialogEntries.add("Short Description");
        displayArrayEntries(addTaskDialogEntries);
        userInput();
    }

    public void showDeleteTaskDialog() {

    }

    public void showEditTaskDialog() {

    }

    public void showShowTaskDialog() {

    }

    public String userInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        return input;
    }

    private void displayArrayEntries(ArrayList entries) {
        entries.forEach(entry -> System.out.println((entries.indexOf(entry) + 1) + ": " + entry));
    }

}
