import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewTest extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    public void start (Stage stage) {
        TableView view = new TableView<>();

        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn distance = new TableColumn("Distanz zur Sonne [km]");
        distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        distance.setStyle("-fx-alignment: top-right;");

        view.getColumns().addAll(name, distance);

        ObservableList<Planet> model = FXCollections.observableArrayList();
        view.setItems(model);

        VBox root = new VBox();
        root.getChildren().add(view);

        model.add(new Planet("Mars", 1201));
        model.add(new Planet("Jupiter", 1244));
        model.add(new Planet("Saturn", 23828));

        Scene scene = new Scene(root, 260, 120);
        stage.setScene(scene);
        stage.setTitle("Planeten");
        stage.show();
    }



}
