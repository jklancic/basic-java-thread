package xyz.blackmonster.thread.local;

public class LocalExecution implements Runnable {

    private ThreadLocal<Var> local = new ThreadLocal<>();

    @Override
    public void run() {
        System.out.println("Starting thread");
        local.set(new Var());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        Var threadSafe = local.get();
        System.out.println("Finished thread " + threadSafe);
    }

    private class Var {
        private final int random;
        private Var() {
            random = (int) (Math.random() * 100D);
        }

        @Override
        public String toString() {
            return "Var{" +
                    "random=" + random +
                    '}';
        }
    }
}
