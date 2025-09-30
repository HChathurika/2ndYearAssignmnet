package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Note;
import model.Notebook;

public class NoteController {

    @FXML
    private TextField titleInput;

    @FXML
    private TextArea contentInput;

    @FXML
    private ListView<String> notesList;

    private Notebook notebook = new Notebook();

    @FXML
    private void addNote(ActionEvent event) {
        String title = titleInput.getText().trim();
        String content = contentInput.getText().trim();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note);

            // Update ListView with note titles
            notesList.getItems().add(title + ": " + content);

            // Clear inputs
            titleInput.clear();
            contentInput.clear();
        }
    }
}
