package xyz.blackmonster.thread.local;

/**
 * Demonstration of thread safe class ThreadLocal
 */
public class ThreadLocalMain {

    public static void main(String[] arg) throws Exception{
        LocalExecution runnable = new LocalExecution();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
