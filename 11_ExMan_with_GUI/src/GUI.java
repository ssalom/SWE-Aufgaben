import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main (String[] args) {

        launch(args);
    }

    Label container;
    Button pack;
    public void start (Stage stage) {

        Container c1 = new Container("Sibirien");
        c1.addItem(new Item("Schaufel", 2, 10));
        c1.addItem(new Item("Pickel", 1, 15));
        c1.addItem(new Item("Sonde", 4, 100));
        c1.addItem(new Item("Schlitten", 50, 1000));

        container = new Label(c1.toString());
        pack = new Button();

        pack.setText("Packen");
        pack.setOnAction(ev -> handlePackBtn(c1, 5));

        VBox root = new VBox();

        root.getChildren().add(pack);
        root.getChildren().add(container);


        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 260, 180);

        stage.setScene(scene);

        stage.setTitle("ExMan");

        stage.show();
    }

    public void handlePackBtn (Container container, int limit) {
        SimpleSelectionEngine sse = new SimpleSelectionEngine();
        this.container.setText(sse.pack(container, 5).toString());
    }

}
