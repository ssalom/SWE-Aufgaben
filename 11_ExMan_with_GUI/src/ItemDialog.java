import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.Optional;

public class ItemDialog extends Dialog<Item> {

    private Optional<Item> result = null;
    private Dialog<Item> dialog = new Dialog<>();


    public ItemDialog () {
        dialog.setTitle("Gegenstand hinzufügen");
        dialog.setHeaderText("Bitter füllen Sie die unterstehenden Felder entsprechend aus.");

        GridPane gpane = new GridPane();
        TextField txtName = new TextField();
        TextField txtWeight = new TextField();
        TextField txtProfit = new TextField();

        txtName.set

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
    }

    private boolean validateInt (String input) {
        if (input.equals("") && (!isInt(input) || toInt(input) <= 0)) {
            showAlert("Warnung", "Ungültige Eingabe", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private boolean validateText(String input) {
        if (input.equals("")) {
            showAlert("Warnung", "Ungültige Eingabe", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private boolean isInt(String value) {
        boolean ok = true;
        for (int position = 0; position < value.length(); position++) {
            char character = value.charAt(position);
            if (!Character.isDigit(character)) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
