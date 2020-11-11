import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage stage) {
        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("Datei");
        Menu helpMenu = new Menu("Hilfe");
        MenuItem openMI = new MenuItem("Öffnen...");
        MenuItem closeMI = new MenuItem("Schliessen...");
        closeMI.setOnAction(e -> close());
        openMI.setOnAction(e -> open());

        fileMenu.getItems().addAll(openMI, closeMI);
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        root.setTop(menuBar);

        Scene scene = new Scene(root, 260, 120);
        stage.setScene(scene);
        stage.setTitle("MenuBar Demo");
        stage.show();

    }

    public void open () {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Öffnen...");
        alert.showAndWait();
    }

    public void close () {
        System.exit(0);
    }

}
