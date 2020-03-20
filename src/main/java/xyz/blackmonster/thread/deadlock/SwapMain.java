package xyz.blackmonster.thread.deadlock;

/**
 * Demonstration resolving dead locks in concurrency.
 */
public class SwapMain {

    public static void main(String[] arg) throws InterruptedException {
        Book microMovement = new Book("978-1492047841", "Monolith to Microservices", "Sam Newman");
        Book microDesigning = new Book("978-1491950357", "Building Microservices: Designing Fine-Grained Systems", "Sam Newman");
        Book microProduction = new Book(" 978-1491965979", "Production-Ready Microservices", "Susan J. Fowler");

        Person personA = new Person("John", "Smith");
        personA.setBorrowed(microMovement);
        Person personB = new Person("John", "Doe");
        personB.setBorrowed(microDesigning);

        checkingBooks(personA, personB);

        SwapExecution swapExecution = new SwapExecution(personA, personB);
        Thread thread1 = new Thread(swapExecution);
        thread1.start();

        Thread.sleep(2000);

        checkingBooks(personA, personB);

        Thread.sleep(1000);

        System.out.println("Person B has new book.");
        personB.setBorrowed(microProduction);

        Thread thread2 = new Thread(swapExecution);
        Thread thread3 = new Thread(swapExecution);

        checkingBooks(personA, personB);

        thread2.start();
        thread3.start();

        Thread.sleep(1000);

        checkingBooks(personA, personB);
    }

    private static void checkingBooks(Person personA, Person personB) {
        System.out.println("Checking books.");
        System.out.println(personA.currentRead());
        System.out.println(personB.currentRead());
    }
}
