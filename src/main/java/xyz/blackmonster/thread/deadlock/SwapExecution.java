package xyz.blackmonster.thread.deadlock;

public class SwapExecution implements Runnable {

    private final Person personA;
    private final Person personB;

    public SwapExecution(Person personA, Person personB) {
        this.personA = personA;
        this.personB = personB;
    }

    private void swap(String threadName) {
        Person firstLock;
        Person secondLock;

        System.out.println("Identifying lock order for " + threadName);

        if (personA.identifier().equals(personB.identifier())) {
            System.out.println("Swap not possible for " + threadName);
            throw new IllegalArgumentException("Can not swap books with self.");
        }

        System.out.println("Setting lock order for " + threadName);
        // ordering locks by sorting persons
        if (personA.identifier().compareTo(personB.identifier()) > 0) {
            firstLock = personA;
            secondLock = personB;
        } else {
            firstLock = personB;
            secondLock = personA;
        }

        synchronized (firstLock) {
            synchronized (secondLock) {
                System.out.println("Swapping books for " + threadName);
                Book tmp = firstLock.getBorrowed();
                firstLock.setBorrowed(secondLock.getBorrowed());
                secondLock.setBorrowed(tmp);
            }
        }
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Started thread " + threadName);
        swap(threadName);
        System.out.println("Finished thread " + threadName);
    }
}
