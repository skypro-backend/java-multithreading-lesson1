package multi.wait;

import java.util.stream.IntStream;

public class ParkingExample {
    private static Parking parking = new WithoutWaitAndNotify();

    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }

    private static class Producer extends Thread {
        @Override
        public void run() {
            IntStream.range(0, 1000)
                    .forEach(ignored -> parking.in());
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            IntStream.range(0, 1000)
                    .forEach(ignored -> parking.out());
        }
    }
}
