package com.example.virtualpet.model;

public class Pet {
    private double x;
    private double y;
    private double speed = 2;

    public Pet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveTowards(double targetX, double targetY) {
        double dx = targetX - x;
        double dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > speed) {
            x += (dx / distance) * speed;
            y += (dy / distance) * speed;
        } else {
            x = targetX;
            y = targetY;
        }
    }

    public double getX() { return x; }
    public double getY() { return y; }
}
