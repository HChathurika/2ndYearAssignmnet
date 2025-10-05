package View;

import Controller.CurrencyController;
import Model.CurrencyModel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrencyConverterView extends Application {

    private CurrencyModel model;
    private CurrencyController controller;

    @Override
    public void start(Stage stage) {
        model = new CurrencyModel();
        controller = new CurrencyController(model);

        // UI controls
        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label fromLabel = new Label("From:");
        ComboBox<String> fromCurrency = new ComboBox<>();
        fromCurrency.getItems().addAll("USD", "EUR", "GBP", "JPY");

        Label toLabel = new Label("To:");
        ComboBox<String> toCurrency = new ComboBox<>();
        toCurrency.getItems().addAll("USD", "EUR", "GBP", "JPY");

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label("Result: ");

        // Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromCurrency, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toCurrency, 1, 2);
        grid.add(convertButton, 0, 3);
        grid.add(resultLabel, 1, 3);

        // Button action
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = fromCurrency.getValue();
                String to = toCurrency.getValue();
                double result = controller.convert(amount, from, to);
                resultLabel.setText("Result: " + result + " " + to);
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        });

        // Scene
        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/CSS/style.css").toExternalForm());

        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
