import com.sun.java.accessibility.util.AccessibilityListenerList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;


import javax.swing.text.html.Option;
import java.beans.beancontext.BeanContext;
import java.util.Optional;
public class GUI extends Application {
    public static void main (String[] args) {

        launch(args);
    }

    private SimpleSelectionEngine engine = new SimpleSelectionEngine();
    private Container allItems = new Container("Sibirien");
    private int limit;
    private Label statusLbl = new Label();
    private VBox appContent = new VBox();
    private Stage stage;

    public void start (Stage stage) {
        this.stage = stage;
        Scene scene = new Scene(createRoot(), 260, 180);
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
        root.setBottom(statusLbl);
        root.setCenter(appContent);
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

        fileMenu.getItems().addAll(openMI, saveMI, closeMI);


        Menu editMenu = new Menu("Bearbeiten");
        MenuItem addItemMI = new MenuItem("Gegenstand hinzufügen...");
        MenuItem setLimitMI = new MenuItem("Limit setzten...");

        addItemMI.setOnAction(e -> add());
        setLimitMI.setOnAction(e -> setLimit(2));

        editMenu.getItems().addAll(addItemMI, setLimitMI);

        Menu packageMenu = new Menu("Packen");
        MenuItem simplePackageMI = new MenuItem("Simple");
        packageMenu.getItems().addAll(simplePackageMI);

        simplePackageMI.setOnAction(e -> pack(allItems, limit));

        menuBar.getMenus().addAll(fileMenu, editMenu, packageMenu);
        return menuBar;
    }

    private void createStatus () {
        statusLbl = new Label("Status");
    }

    private void open () {
        allItems.clearContainer();
        allItems.addItem(new Item("Schaufel", 2, 10));
        allItems.addItem(new Item("Pickel", 1, 15));
        allItems.addItem(new Item("Sonde", 4, 100));
        allItems.addItem(new Item("Schlitten", 50, 1000));
        appContent.getChildren().clear();
        appContent.getChildren().add(new Label(allItems.toString()));
    }

    private void saveAs () {
        statusLbl.setText("Speichern nocht nicht implementiert.");

    }

    private void add () {
        Dialog<Item> dialog = new Dialog<>();
        dialog.setTitle("Gegenstand hinzufügen");
        dialog.setHeaderText("Bitter füllen Sie die unterstehenden Felder entsprechend aus.");


        GridPane gpane = new GridPane();
        TextField txtName = new TextField();
        TextField txtWeight = new TextField();
        TextField txtProfit = new TextField();

        gpane.add(new Label("Name: "), 1 , 1);
        gpane.add(txtName, 2, 1);
        gpane.add(new Label("Gewicht: "), 1, 2);
        gpane.add(txtWeight, 2, 2);
        gpane.add(new Label("Profit: "), 1, 3);
        gpane.add(txtProfit, 2,3);

        ButtonType buttonTypeSubmit = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeSubmit);

        dialog.getDialogPane().setContent(gpane);
        dialog.setResultConverter(new Callback<ButtonType, Item>() {
            @Override
            public Item call(ButtonType b) {
                if (b == buttonTypeSubmit) {

                    return new Item(txtName.getText(), Integer.parseInt(txtWeight.getText()), Integer.parseInt(txtProfit.getText()));
                }

                return null;
            }
        });
        Optional<Item> result = dialog.showAndWait();
        if(result.isPresent()) {
            allItems.addItem(result.get());
            appContent.getChildren().clear();
            appContent.getChildren().add(new Label(allItems.toString()));
        }
    }

    private void setLimit (int limit) {
        this.limit = limit;
    }

    public void pack (Container container, int limit) {
        allItems = engine.pack(container, limit);
        appContent.getChildren().clear();
        appContent.getChildren().add(new Label(allItems.toString()));
    }

}
