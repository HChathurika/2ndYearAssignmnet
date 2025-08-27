public class TelevisionViewer {
    public static void main(String[] args) {
        Television myTV = new Television();
        myTV.turnOn();

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);
            boolean tired = false;

            while (!tired) {
                myTV.watch();
                myTV.nextChannel();
                if (myTV.getChannel() % 4 == 0) {
                    tired = true;
                }
            }

            myTV.turnOff();
            System.out.println("Falling asleep\n");
            myTV.turnOn();
        }
    }
}


