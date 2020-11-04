import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    TextField tfl;
    Button btn;
    Label lbl;

    public void start (Stage stage) {
        tfl = new TextField();
        btn = new Button();
        btn.setText("Ok");
        btn.setOnAction(ev -> handle());
        lbl = new Label("Test");


        VBox root = new VBox();
        
        root.getChildren().add(tfl);
        root.getChildren().add(btn);
        root.getChildren().add(lbl);

        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 260, 120);
        stage.setScene(scene);

        stage.setTitle("Hello FX");
        stage.setOnCloseRequest(ev -> exit());
        stage.show();
        
    }

    public void handle() {
        String text = tfl.getText();
        lbl.setText(text);
    }

    public void exit() {
        System.out.println("Bye bye!");
        System.exit(0);
    }
}
