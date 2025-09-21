package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private DictionaryController controller = new DictionaryController();

    public void start(Stage stage) {
        // Components
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");
        Button searchButton = new Button("Search");
        TextArea meaningArea = new TextArea();
        meaningArea.setEditable(false);
        meaningArea.setPrefHeight(100);

        FlowPane pane = new FlowPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.getChildren().addAll(wordInput, searchButton, meaningArea);

        // Event
        searchButton.setOnAction(e -> {
            String word = wordInput.getText();
            String meaning = controller.search(word);
            meaningArea.setText(meaning);
        });

        Scene scene = new Scene(pane, 400, 150);
        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }
}
