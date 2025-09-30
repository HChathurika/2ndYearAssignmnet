package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Currency;
import controller.CurrencyController;
import java.util.List;

public class CurrencyView {
    private CurrencyController controller;

    public CurrencyView(CurrencyController controller) {
        this.controller = controller;
    }

    public void start(Stage stage) {
        stage.setTitle("Currency Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label fromLabel = new Label("From:");
        ComboBox<Currency> fromCombo = new ComboBox<>();

        Label toLabel = new Label("To:");
        ComboBox<Currency> toCombo = new ComboBox<>();

        Label resultLabel = new Label("Result: ");
        Button convertButton = new Button("Convert");

        List<Currency> currencies = controller.getAllCurrencies();
        fromCombo.getItems().addAll(currencies);
        toCombo.getItems().addAll(currencies);

        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromCombo, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toCombo, 1, 2);
        grid.add(convertButton, 0, 3);
        grid.add(resultLabel, 1, 3);

        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency from = fromCombo.getValue();
                Currency to = toCombo.getValue();
                if (from != null && to != null) {
                    double result = controller.convert(amount, from, to);
                    resultLabel.setText(String.format("Result: %.4f %s", result, to.getAbbreviation()));
                } else {
                    resultLabel.setText("Please select both currencies.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid amount.");
            }
        });

        Scene scene = new Scene(grid, 400, 250);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
