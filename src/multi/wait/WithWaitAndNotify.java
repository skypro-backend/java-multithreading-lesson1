package multi.wait;

public class WithWaitAndNotify implements Parking {
    private static final int PARKING_PLACE_MAX_COUNT = 500;
    private int carCount = 0;


    public synchronized void in() {
        if (carCount == PARKING_PLACE_MAX_COUNT) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        carCount++;
        notify();
        System.out.printf("Количество машин :%d\nКоличество свободных мест %d\n", carCount, PARKING_PLACE_MAX_COUNT - carCount);
    }

    public synchronized void out()  {
        if (carCount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        carCount--;
        notify();
        System.out.printf("Количество машин :%d\nКоличество свободных мест %d\n", carCount, PARKING_PLACE_MAX_COUNT - carCount);
    }
}
