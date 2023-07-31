package multi.wait;

public class WithoutWaitAndNotify implements Parking {
    private static final int PARKING_PLACE_MAX_COUNT = 500;
    private int carCount = 0;

    public synchronized void in() {
        carCount++;
        System.out.printf("Количество машин :%d\nКоличество свободных мест %d\n", carCount, PARKING_PLACE_MAX_COUNT - carCount);
        notify();
    }

    public synchronized void out() {
        carCount--;
        System.out.printf("Количество машин :%d\nКоличество свободных мест %d\n", carCount, PARKING_PLACE_MAX_COUNT - carCount);
        notify();
    }
}
