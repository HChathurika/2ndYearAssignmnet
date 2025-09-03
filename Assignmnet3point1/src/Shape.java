public class Shape {
    protected String color; // common property for all shapes

    public Shape() {
        this.color = "undefined"; // default color
    }

    public Shape(String color) {
        this.color = color;
    }

    // Method to calculate area (base implementation returns 0)
    public double calculateArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "Shape with color: " + color;
    }
}


