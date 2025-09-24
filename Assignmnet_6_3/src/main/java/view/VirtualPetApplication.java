package view;

import controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Pet;

/**
 * View class for the Virtual Pet application.
 * Displays the pet and updates its position based on mouse events.
 */
public class VirtualPetApplication extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double PET_SPEED = 3.0;

    private Canvas canvas;
    private GraphicsContext gc;
    private Image petImage;

    private PetController controller;

    @Override
    public void start(Stage stage) {
        // --- Create canvas and graphics context ---
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // --- Load pet image from resources ---
        petImage = new Image(
                VirtualPetApplication.class
                        .getResource("/images/cute_pet.jpg") // <- your file
                        .toExternalForm()
        );

        // --- Create Model and Controller ---
        Pet pet = new Pet(WIDTH / 2, HEIGHT / 2, PET_SPEED);
        controller = new PetController(pet, this);

        // --- Mouse events ---
        canvas.setOnMouseMoved(e -> controller.setTarget(e.getX(), e.getY()));
        canvas.setOnMouseExited(e -> controller.stopMoving());

        // --- Scene setup ---
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        stage.setTitle("Virtual Pet");
        stage.setScene(scene);
        stage.show();

        // --- Start animation ---
        controller.start();
    }

    /**
     * Called by the controller every frame to redraw the pet.
     *
     * @param x current pet X position
     * @param y current pet Y position
     */
    public void updateCanvas(double x, double y) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // Draw pet image centered at (x, y)
        gc.drawImage(
                petImage,
                x - petImage.getWidth() / 2,
                y - petImage.getHeight() / 2
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
