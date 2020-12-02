import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GrafikTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final int TIME = 5000;
        Group root = new Group();

        Rectangle rectangle = new Rectangle(100,100, 300, 200);
        rectangle.setFill(Color.BLUE);

        root.getChildren().add(rectangle);
        Scene scene = new Scene(root, 600, 500, Color.BLACK);
        primaryStage.setTitle("JavaFX Grafik-DEemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
