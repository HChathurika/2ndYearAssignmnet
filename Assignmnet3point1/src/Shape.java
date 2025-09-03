public class Shape {
    protected String color;

    public Shape() {
        this.color = "undefined";
    }

    public Shape(String color) {
        this.color = color;
    }


    public double calculateArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "Shape with color: " + color;
    }
}


