package xyz.blackmonster.thread.wait;

public class MonitorWait implements Runnable {

    private final MonitorObject object;

    public MonitorWait(MonitorObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (object) {
            try {
                System.out.println("Starting to wait for thread " + name);
                object.wait();
            } catch (InterruptedException e) {

            }
            System.out.println("Message is: " + object.getMsg() + "for " + name);
            System.out.println("Finished waiting for thread " + name);
        }
    }
}
