import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {
        TaskManager taskManager = TaskManager.getInstance();

        taskManager.run();
    }

}
