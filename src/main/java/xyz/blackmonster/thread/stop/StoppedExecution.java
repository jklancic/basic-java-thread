package xyz.blackmonster.thread.stop;

public class StoppedExecution implements Runnable {

    private boolean shouldWork = true;

    private synchronized boolean shouldContinue() {
        return shouldWork;
    }

    public synchronized void stopWork() {
        shouldWork = false;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Start thread execution for " + threadName);
        while (shouldContinue()) {
            try {
                System.out.println("Thread " + threadName + " is still working.");
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
        System.out.println("End thread execution for " + threadName);
    }
}
