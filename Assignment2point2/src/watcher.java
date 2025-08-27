public class watcher {
    public static void main(String[] args) {
        Television tv = new Television();

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);
            tv.turnOn();

            if (day % 2 == 1) {
                for (int i = 0; i < 6; i++) {
                    tv.watch();
                    tv.nextChannel();
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    tv.watch();
                    tv.nextChannel();
                }
            }

            System.out.println("Falling asleep");
            tv.turnOff();
        }
    }
}

