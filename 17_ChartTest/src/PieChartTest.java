import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PieChartTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PieChart chart = new PieChart();
        chart.setTitle("Statistik");

        Data data = new Data("Männer", 3344);
        chart.getData().add(data);

        data = new Data("Frauen", 4445);
        chart.getData().add(data);

        data = new Data("Kinder", 555);
        chart.getData().add(data);

        StackPane root = new StackPane();
        root.getChildren().add(chart);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Pie Chart");
        primaryStage.show();
    }
}
