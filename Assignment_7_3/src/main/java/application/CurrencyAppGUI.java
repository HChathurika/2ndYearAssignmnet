package application;

import dao.CurrencyDao;
import entity.Currency;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import datasource.MariaDbJpaConnection;

public class CurrencyAppGUI extends Application {


    private TableView<Currency> table;
    private final CurrencyDao dao = new CurrencyDao();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Manager (JPA)");

        table = new TableView<>();
        TableColumn<Currency, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(60);

        TableColumn<Currency, String> codeCol = new TableColumn<>("Code");
        codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        codeCol.setPrefWidth(100);

        TableColumn<Currency, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(240);

        TableColumn<Currency, Double> rateCol = new TableColumn<>("Rate");
        rateCol.setCellValueFactory(new PropertyValueFactory<>("rate"));
        rateCol.setPrefWidth(120);

        table.getColumns().addAll(idCol, codeCol, nameCol, rateCol);

        Button loadBtn = new Button("Load Currencies");
        loadBtn.setOnAction(e -> loadCurrencies());

        Button addBtn = new Button("Add Currency");
        addBtn.setOnAction(e -> showAddCurrencyDialog(primaryStage));

        HBox buttons = new HBox(10, loadBtn, addBtn);
        buttons.setPadding(new Insets(10));

        VBox root = new VBox(10, table, buttons);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        // initial load
        loadCurrencies();
    }

    private void loadCurrencies() {
        try {
            ObservableList<Currency> list = FXCollections.observableArrayList(dao.findAll());
            table.setItems(list);
        } catch (Exception ex) {
            showError("Failed to load currencies", ex.getMessage());
        }
    }

    private void showAddCurrencyDialog(Stage owner) {
        Stage dialog = new Stage();
        dialog.initOwner(owner);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Add Currency");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Label codeLabel = new Label("Code:");
        TextField codeField = new TextField();

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label rateLabel = new Label("Rate:");
        TextField rateField = new TextField();

        Button saveBtn = new Button("Save");
        saveBtn.setOnAction(e -> {
            String code = codeField.getText().trim();
            String name = nameField.getText().trim();
            String rateText = rateField.getText().trim();

            if (code.isEmpty() || name.isEmpty() || rateText.isEmpty()) {
                showError("Validation error", "All fields are required.");
                return;
            }

            double rate;
            try {
                rate = Double.parseDouble(rateText);
            } catch (NumberFormatException ex) {
                showError("Validation error", "Rate must be a number.");
                return;
            }

            Currency c = new Currency(code, name, rate);
            try {
                dao.persist(c);
                dialog.close();
                loadCurrencies(); // refresh
            } catch (Exception ex) {
                showError("Database error", ex.getMessage());
            }
        });

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(e -> dialog.close());

        HBox hb = new HBox(10, saveBtn, cancelBtn);

        grid.addRow(0, codeLabel, codeField);
        grid.addRow(1, nameLabel, nameField);
        grid.addRow(2, rateLabel, rateField);
        grid.add(hb, 1, 3);

        Scene scene = new Scene(grid, 380, 200);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    private void showError(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void stop() throws Exception {
        // cleanly close EntityManagerFactory/EntityManager
        MariaDbJpaConnection.close();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
