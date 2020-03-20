package xyz.blackmonster.thread.calc;

public class ConcurrentCalculation {

    private Integer valueA = 0;

    private Integer valueB = 0;

    private Integer valueC = 0;

    public void sum(int a, int b, int c) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Started sum in " + threadName);
        synchronized (this.valueA) {
            System.out.println("Adding sum to A in " + threadName);
            valueA = valueA + a;
        }

        synchronized (this.valueB) {
            System.out.println("Adding sum to B in " + threadName);
            valueB = valueB + a;
        }

        synchronized (this.valueC) {
            System.out.println("Adding sum to C in " + threadName);
            valueC = valueC + a;
        }

        System.out.println("Finished sum in " + threadName);
    }

    public String getValues() {
        return String.format("Value a(%d), b(%d), c(%d)", valueA, valueB, valueC);
    }
}
