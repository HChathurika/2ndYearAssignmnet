public class TV {
    private int channel;
    private boolean on;
    private final int maxChannel = 10;


    public TV() {
        this.channel = 1;
        this.on = false;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void nextChannel() {
        if (on) {
            channel++;
            if (channel > maxChannel) {
                channel = 1; // wrap around
            }
        }
    }


    public void watch() {
        if (on) {
            System.out.println("Watching channel " + channel);
        }
    }


    public int getChannel() {
        return channel;
    }
}



