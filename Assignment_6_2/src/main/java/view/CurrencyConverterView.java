package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CurrencyConverterView extends Application {

    @Override
    public void start(Stage stage) {
        // Build a minimal test window
        Label label = new Label("JavaFX is working!");
        Scene scene = new Scene(label, 300, 200);

        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();   // <-- THIS is what makes the window appear
    }

    public static void main(String[] args) {
        launch(args);  // This triggers JavaFX runtime, which calls start()
    }
}
