package xyz.blackmonster.thread.stop;

/**
 * Demonstrates how to stop a thread, since threads do not have a stop method (they stop once the code is fully executed).
 */
public class ManualStopMain {

    public static void main (String[] arg) {
        StoppedExecution[] threads = new StoppedExecution[50];
        for (int i=0; i<50; i++) {
            threads[i] = new StoppedExecution();
            Thread t = new Thread(threads[i]);
            t.start();
        }

        for (int i=0; i<50; i++) {
            threads[i].stopWork();
        }
    }
}
