package multi.synch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WithSynchronised {
    private static List<Double> doubleList = new ArrayList<>();

    public static void main(String[] args) {
        IntStream.range(0, 10)
                .mapToObj(ignored -> new Thread(WithSynchronised::someMethod))
                .forEach(Thread::start);
    }

    public static synchronized void someMethod() {
        for (int i = 0; i < 100000; i++) {
            doubleList.add(Math.random() / Math.random());
        }
        System.out.println(doubleList.size());
        doubleList.clear();
    }
}
