package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import model.Note;
import model.Notebook;

public class NoteController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    @FXML
    private VBox notesContainer;

    private final Notebook notebook = new Notebook();

    @FXML
    private void handleAddNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (title.isEmpty() || content.isEmpty()) {
            return; // ignore empty notes
        }

        Note note = new Note(title, content);
        notebook.addNote(note);

        // Display note in the VBox
        Label noteLabel = new Label(note.toString());
        notesContainer.getChildren().add(noteLabel);

        // Clear inputs
        titleField.clear();
        contentArea.clear();
    }
}
