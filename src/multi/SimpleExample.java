package multi;

public class SimpleExample {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("I'm Thread");
        Thread thread = new Thread(runnable);

        thread.start();

        System.out.println("I'm Main");
    }


}
