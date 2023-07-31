package multi.deadlock.bad;

public class Friend {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public synchronized void throwBall(Friend catcher) {
        System.out.printf("%s бросил мяч %sу\n", name, catcher.name);

        catcher.throwBall(this);
    }

    public static void main(String[] args) {
        Friend chel = new Friend("Чел");
        Friend bratan = new Friend("Братан");

        new Thread(() -> chel.throwBall(bratan)).start();
        new Thread(() -> bratan.throwBall(chel)).start();
    }
}
