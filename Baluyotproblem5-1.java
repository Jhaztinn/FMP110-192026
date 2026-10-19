// Programmed by: Jhaztintroy Baluyot
package com.mycompany.baluyotproblem3;

import java.util.Scanner;

class LibraryException extends Exception {
    public LibraryException(String message) { super(message); }
}

class Book {
    private final int id;
    private final String title;
    private final int totalCopies;   // invariant: available + borrowed == totalCopies
    private int available;
    private int borrowed;

    public Book(int id, String title, int copies) {
        this.id = id;
        this.title = title;
        this.totalCopies = copies;
        this.available = copies;
        this.borrowed = 0;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getAvailable() { return available; }
    public int getBorrowed() { return borrowed; }

    // Validate first, then change both counts together (atomic update)
    public void borrow() throws LibraryException {
        if (available <= 0) throw new LibraryException("No copies available.");
        available--;
        borrowed++;
    }

    public void returnCopy() throws LibraryException {
        if (borrowed <= 0) throw new LibraryException("No borrowed copies to return.");
        borrowed--;
        available++;
    }

    public String status() {
        return "Available " + available + ", borrowed " + borrowed;
    }

    @Override
    public String toString() {
        return id + " " + title + " - " + status() + " (total " + totalCopies + ")";
    }
}

class Library {
    private final Book[] books = {
        new Book(1, "Java Basics", 2),
        new Book(2, "Algorithms", 1),
        new Book(3, "Databases", 0)
    };

    public Book find(int id) throws LibraryException {
        for (int i = 0; i < books.length; i++)
            if (books[i].getId() == id) return books[i];
        throw new LibraryException("Book not found.");
    }

    public Book[] getBooks() { return books; }
}

public class Baluyotproblem3 {
    private static final Scanner in = new Scanner(System.in);

    private static int readInt(String prompt) throws LibraryException {
        System.out.print(prompt);
        try {
            return Integer.parseInt(in.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new LibraryException("Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        boolean running = true;
        while (running) {
            System.out.println("\nMenu: 1 Borrow | 2 Return | 3 Find | 4 List | 0 Exit");
            try {
                int choice = readInt("Choice: ");
                switch (choice) {
                    case 1: {
                        Book b = library.find(readInt("Book ID: "));
                        b.borrow();
                        System.out.println(b.status());
                        break;
                    }
                    case 2: {
                        Book b = library.find(readInt("Book ID: "));
                        b.returnCopy();
                        System.out.println(b.status());
                        break;
                    }
                    case 3: {
                        Book b = library.find(readInt("Book ID: "));
                        System.out.println(b.status());
                        break;
                    }
                    case 4:
                        for (Book b : library.getBooks()) System.out.println(b);
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        throw new LibraryException("Invalid menu choice.");
                }
            } catch (LibraryException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("--------------------");
            }
        }
        System.out.println("Goodbye!");
    }
}
