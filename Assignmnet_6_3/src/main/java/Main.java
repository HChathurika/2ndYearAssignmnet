package com.example.virtualpet.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;
    private Image petImage;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Load pet image
        petImage = new Image(getClass().getResource("/pet.png").toExternalForm());

        controller = new PetController(gc, petImage);

        canvas.setOnMouseMoved(event -> controller.startMoving(event.getX(), event.getY()));
        canvas.setOnMouseExited(event -> controller.stopMoving());

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Virtual Pet");
        primaryStage.setScene(scene);
        primaryStage.show();

        controller.startAnimation();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
