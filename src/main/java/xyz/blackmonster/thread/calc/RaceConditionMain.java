package xyz.blackmonster.thread.calc;

/**
 * Demonstration of resolved race condition.
 */
public class RaceConditionMain {

    public static void main(String[] arg) {
        System.out.println("Started application");
        ConcurrentCalculation calculation = new ConcurrentCalculation();
        for (int i=0;i<20;i++) {
            CalculationExecutor runner = new CalculationExecutor(calculation);
            Thread thread = new Thread(runner);
            thread.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception " + e.getMessage());
        }
        System.out.println("Finished application");
        System.out.println("Final result should Value a(20), b(20), c(20)");
        System.out.println(calculation.getValues());
    }
}
