package xyz.blackmonster.thread.deadlock;

public class Person {

    private final String name;

    private final String surname;

    private Book borrowed;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Book getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Book borrowed) {
        this.borrowed = borrowed;
    }

    public String identifier() {
        return String.format("%s %s", name, surname);
    }

    public String currentRead() {
        if (getBorrowed() == null) {
            return String.format("%s is not reading anything right now", identifier());
        }

        return String.format("%s is currently reading %s from %s", identifier(), borrowed.getTitle(), borrowed.getAuthor());
    }
}
