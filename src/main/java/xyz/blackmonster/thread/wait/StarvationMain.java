package xyz.blackmonster.thread.wait;

/**
 * Basic demonstration of thread starvation. Just change class MonitorNotify's run method and use notify instead of notifyAll.
 */
public class StarvationMain {

    public static void main(String[] arg) {
        MonitorObject object = new MonitorObject("Process it");
        MonitorWait first = new MonitorWait(object);
        MonitorWait second = new MonitorWait(object);
        MonitorWait third = new MonitorWait(object);
        MonitorNotify fourth = new MonitorNotify(object, 600, "Fourth 4 ever");

        (new Thread(first)).start();
        (new Thread(second)).start();
        (new Thread(third)).start();
        (new Thread(fourth)).start();
    }
}
