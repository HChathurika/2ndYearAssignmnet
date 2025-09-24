package model;

public class Pet {
    private double x;
    private double y;
    private double speed;

    public Pet(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void moveToward(double targetX, double targetY) {
        double dx = targetX - x;
        double dy = targetY - y;
        double dist = Math.sqrt(dx*dx + dy*dy);
        if (dist > 0.5) {
            x += (dx / dist) * speed;
            y += (dy / dist) * speed;
        }
    }

    public boolean hasReached(double tx, double ty) {
        return Math.abs(x - tx) < 1 && Math.abs(y - ty) < 1;
    }

    public double getX() { return x; }
    public double getY() { return y; }
}
