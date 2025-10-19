package task1;

public class Pen {

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    private boolean capOn;
    private Color color;

    // Default constructor — default color RED, cap is ON
    public Pen() {
        this.color = Color.RED;
        this.capOn = true;
    }

    // Constructor with chosen color
    public Pen(Color color) {
        this.color = color;
        this.capOn = true;
    }

    // Removes the cap
    public void capOff() {
        capOn = false;
    }

    // Puts the cap on
    public void capOn() {
        capOn = true;
    }

    // Changes pen color (only effective if cap is ON)
    public void changeColor(Color newColor) {
        this.color = newColor;
    }

    // Draws if cap is off, otherwise empty string
    public String draw() {
        if (capOn) {
            return "";
        }
        return "Drawing " + color.toString();
    }
}
