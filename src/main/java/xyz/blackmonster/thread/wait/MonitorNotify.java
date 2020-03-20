package xyz.blackmonster.thread.wait;

public class MonitorNotify implements Runnable {

    private final MonitorObject object;

    private final int sleepTime;

    private final String message;

    public MonitorNotify(MonitorObject object, int sleepTime, String message) {
        this.object = object;
        this.sleepTime = sleepTime;
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("Starting to notify.");
            System.out.println("Current message is: " + object.getMsg());
            System.out.println("Changing message.");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            object.setMsg(message);
            object.notifyAll();
            System.out.println("Finished notifying.");
        }
    }
}
