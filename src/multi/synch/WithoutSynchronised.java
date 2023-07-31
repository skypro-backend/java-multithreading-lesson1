package multi.synch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WithoutSynchronised {
    private static List<Double> doubleList = new ArrayList<>();

    public static void main(String[] args) {
        IntStream.range(0, 10)
                .mapToObj(ignored -> new Thread(WithoutSynchronised::someMethod))
                .forEach(Thread::start);
    }

    public static void someMethod() {
        for (int i = 0; i < 1000000; i++) {
            Double d = Math.random() / Math.random();

            synchronized (doubleList) {
                doubleList.add(d);
            }

        }
        System.out.println(doubleList.size());
        doubleList.clear();
    }
}
