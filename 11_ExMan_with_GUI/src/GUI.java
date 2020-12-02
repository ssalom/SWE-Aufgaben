import com.sun.java.accessibility.util.AccessibilityListenerList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.util.Optional;

public class GUI extends Application {
    private SimpleSelectionEngine engine = new SimpleSelectionEngine();
    private Container allItems = new Container("Sibirien");
    private int limit;
    private Label statusLbl = new Label();
    private Stage stage;
    private ObservableList<Item> selectedItemsModel =  FXCollections.observableArrayList();
    private ObservableList allItemsModel =  FXCollections.observableArrayList();
    private ObservableList<XYChart.Series<Number, Number>> chartData = FXCollections.observableArrayList();

    public static void main (String[] args) {

        launch(args);
    }

    public void start (Stage stage) {
        this.stage = stage;
        Scene scene = new Scene(createRoot(), 550, 400);
        stage.setScene(scene);
        setTitle("ExMan");
        stage.show();
    }

    private void setTitle (String title) {
        stage.setTitle(title);
    }

    private BorderPane createRoot () {
        BorderPane root = new BorderPane();
        root.setTop(createMenu());
        root.setLeft(createTable());
        root.setCenter(getScatterChart());
        root.setRight(createList());
        root.setBottom(createStatus());
        return root;
    }

    private MenuBar createMenu () {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("Datei");
        MenuItem openMI = new MenuItem("Öffnen...");
        MenuItem saveMI = new MenuItem("Speichern unter...");
        MenuItem closeMI = new MenuItem("Beenden");

        openMI.setOnAction(e -> open());
        saveMI.setOnAction(e -> saveAs());
        closeMI.setOnAction(e -> exit());

        fileMenu.getItems().addAll(openMI, saveMI, closeMI);

        Menu editMenu = new Menu("Bearbeiten");
        MenuItem addItemMI = new MenuItem("Gegenstand hinzufügen...");
        MenuItem setLimitMI = new MenuItem("Limit setzten...");

        addItemMI.setOnAction(e -> add());
        setLimitMI.setOnAction(e -> setLimit());

        editMenu.getItems().addAll(addItemMI, setLimitMI);

        Menu packageMenu = new Menu("Packen");
        MenuItem simplePackageMI = new MenuItem("Simple");
        packageMenu.getItems().addAll(simplePackageMI);

        simplePackageMI.setOnAction(e -> pack());

        menuBar.getMenus().addAll(fileMenu, editMenu, packageMenu);
        return menuBar;
    }

    private TableView createTable () {
        TableView tableView = new TableView();

        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn weight = new TableColumn("Gewicht [kg]");
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn profit = new TableColumn("Profit [CHF]");
        profit.setCellValueFactory(new PropertyValueFactory<>("profit"));

        tableView.getColumns().addAll(name, weight, profit);

        tableView.setItems(allItemsModel);

        return tableView;
    }

    private ListView createList () {
        ListView listView = new ListView<Item>(selectedItemsModel);
        return listView;
    }

    private Label createStatus () {
        setStatus("Status");
        return statusLbl;
    }

    private void updateChartData (Container container) {
        chartData.clear();
        for (Item item : container.getItems()) {
            XYChart.Series series = new XYChart.Series();
            XYChart.Data<Number, Number>  data = new XYChart.Data<>(item.getWeight(), item.getProfit());
            data.setNode(createDataPointLabel(item.getName()));
            series.getData().add(data);
            chartData.add(series);
        }
    }

    private Label createDataPointLabel (String labelName) {
        Label label = new Label();
        label.setText(labelName);
        return label;
    }

    private ScatterChart<Number, Number> getScatterChart () {
            NumberAxis xAxis = new NumberAxis();
            NumberAxis yAxis = new NumberAxis();

            xAxis.setLabel("Gewicht");
            yAxis.setLabel("Profit");
            ScatterChart<Number, Number> chart = new ScatterChart<>(xAxis, yAxis);
            chart.setData(chartData);
        return chart;
    }

    private void open () {
        allItems.clearContainer();
        allItems.addItem(new Item("Schaufel", 10, 100));
        allItems.addItem(new Item("Pickel", 5, 200));
        allItems.addItem(new Item("Sonde", 4, 400));
        allItems.addItem(new Item("Schlitten", 15, 1000));

        setStatus("Vordefinierter Container wurde erstellt.");
        allItemsModel.clear();
        allItemsModel.addAll(allItems.getItems());
        updateChartData(allItems);
    }

    private void saveAs () {
        setStatus("Speichern nocht nicht implementiert.");

    }

    private void add () {
        ItemDialog inputDialog = new ItemDialog();

        Optional<Item> result = inputDialog.showAndWait();
        if(result.isPresent()) {
            allItems.addItem(result.get());
            allItemsModel.add(result.get());
        }
        updateChartData(allItems);
    }

    private void setLimit () {
        TextInputDialog limitDialog = new TextInputDialog();

        Optional<String> result = limitDialog.showAndWait();
        this.limit = Integer.parseInt(result.get());
    }

    private void pack () {
        if(limit == 0) {
            setLimit();
        }
        allItems = engine.pack(allItems, limit);
        setStatus("Container wurde gepackt.");

        selectedItemsModel.addAll(allItems.getItems());
    }

    private void exit () {
        System.exit(0);
    }

    private void setStatus (String message) {
        statusLbl.setText(message);
    }




}
