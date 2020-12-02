import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScatterChartTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X-Achse");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y-Achse");

        ScatterChart<Number, Number> chart = new ScatterChart<>(xAxis, yAxis);

       Series<Number, Number> serie1 = new Series<>();
       serie1.setName("Serie 1");
       Data<Number, Number> data = new Data<>(10, 10);
       serie1.getData().add(data);
       data = new Data<Number, Number>(5, 5);
       serie1.getData().add(data);
       chart.getData().add(serie1);

        Series<Number, Number> serie2 = new Series<>();
        serie2.setName("Serie 2");
        data = new Data<>(20, 20);
        serie2.getData().add(data);
        data = new Data<Number, Number>(40, 40);
        serie2.getData().add(data);

        chart.getData().add(serie2);



        StackPane root = new StackPane();
        root.getChildren().add(chart);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Pie Chart");
        primaryStage.show();
    }
}
