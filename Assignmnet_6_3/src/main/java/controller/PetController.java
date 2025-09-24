package controller;

import model.Pet;
import view.VirtualPetApplication;

import javafx.animation.AnimationTimer;

public class PetController {

    private final Pet pet;
    private final VirtualPetApplication gui;

    private double targetX;
    private double targetY;
    private boolean moving = false;

    public PetController(Pet pet, VirtualPetApplication gui) {
        this.pet = pet;
        this.gui = gui;
    }

    /** Start the animation loop */
    public void start() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (moving) {
                    pet.moveToward(targetX, targetY);
                    if (pet.hasReached(targetX, targetY)) {
                        moving = false;
                    }
                }
                gui.updateCanvas(pet.getX(), pet.getY());
            }
        }.start();
    }

    /** Called by the GUI when mouse moves */
    public void setTarget(double x, double y) {
        this.targetX = x;
        this.targetY = y;
        this.moving = true;
    }

    /** Called by the GUI when mouse exits canvas */
    public void stopMoving() {
        this.moving = false;
    }
}

