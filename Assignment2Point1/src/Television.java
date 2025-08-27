public class Television {
    public int channel;
    private boolean on;
    private final int maxChannel = 10;

    public Television() {
        channel = 1;
        on = false;

    }
    public void turnOn(){
        on = true;

    }
    public void turnOff(){
        on = false;

    }
    public void nextChannel(){
        if (on) {
            channel++;
            if (channel > maxChannel) {
                channel = 1;
            }

        }
    }
    public void watch(){
        if (on) {
            System.out.println("Watching channel" + channel);

        }
    }
    public int getChannel(){
        return channel;

    }
    public void setChannel(int channel) {
        if (channel >= 1 && channel <= maxChannel) {
            this.channel = channel;

        }
    }
        public boolean isOn () {
            return on;
        }


    }