package application;

import dao.CurrencyDao;
import entity.Currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class CurrencyAppGUI extends Application {

    private CurrencyDao dao = new CurrencyDao();
    private TextArea outputArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter");

        outputArea.setEditable(false);
        outputArea.setPrefSize(400, 300);

        Button loadButton = new Button("Load Currencies");
        loadButton.setOnAction(e -> displayCurrencies());

        Button addButton = new Button("Add Currency");
        addButton.setOnAction(e -> openAddCurrencyWindow());

        HBox buttons = new HBox(10, loadButton, addButton);

        VBox root = new VBox(10, buttons, outputArea);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 450, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayCurrencies() {
        List<Currency> currencies = dao.findAll();
        outputArea.clear();
        for (Currency c : currencies) {
            outputArea.appendText(c.getCode() + " - " + c.getName() + " - " + c.getRate() + "\n");
        }
    }

    private void openAddCurrencyWindow() {
        Stage stage = new Stage();
        stage.setTitle("Add New Currency");

        TextField codeField = new TextField();
        TextField nameField = new TextField();
        TextField rateField = new TextField();

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Code:"), 0, 0);
        grid.add(codeField, 1, 0);
        grid.add(new Label("Name:"), 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(new Label("Rate:"), 0, 2);
        grid.add(rateField, 1, 2);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                String code = codeField.getText();
                String name = nameField.getText();
                double rate = Double.parseDouble(rateField.getText());
                dao.persist(new Currency(code, name, rate));
                stage.close();
                displayCurrencies(); // Refresh main canvas
            } catch (Exception ex) {
                showError("Invalid input or database error!");
            }
        });

        VBox vbox = new VBox(10, grid, saveButton);
        vbox.setPadding(new Insets(10));

        stage.setScene(new Scene(vbox, 300, 200));
        stage.showAndWait();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

