public class App {
    public static void main(String[] args) throws Exception {
        ClockDisplay clock = new ClockDisplay();

        // going forward for 1hour which equals 3600 seconds
        for (int i = 0; i < 3600; i++) {
            clock.timeTick();
            System.out.println(clock.getTime());
        }

        clock.timeTick();
        System.out.println(clock.getTime());
    }
}
