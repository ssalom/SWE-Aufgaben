package Views;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.Optional;

public class ItemDialog extends Dialog<Item> {
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
        allItemsModel.add(result.get());
    }
}
