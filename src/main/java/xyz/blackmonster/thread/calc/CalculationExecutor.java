package xyz.blackmonster.thread.calc;

public class CalculationExecutor implements Runnable {

    private final ConcurrentCalculation calculation;

    public CalculationExecutor(ConcurrentCalculation calculation) {
        this.calculation = calculation;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Started sum in " + threadName);
        calculation.sum(1, 1,1);
        System.out.println("Finished sum in " + threadName + "with result " + calculation.getValues());
    }
}
