// Programmed by: Jhaztintroy Baluyot
package com.mycompany.baluyotproblem3;
import java.util.Scanner;

enum EnrollmentStatus { ACTIVE, DROPPED }

class EnrollmentException extends Exception {
    public EnrollmentException(String message) { super(message); }
}

class Learner {
    private final int id;
    private final String name;
    private EnrollmentStatus status = EnrollmentStatus.ACTIVE;

    public Learner(int id, String name) { this.id = id; this.name = name; }
    public int getId() { return id; }
    public EnrollmentStatus getStatus() { return status; }

    public void drop() throws EnrollmentException {
        if (status == EnrollmentStatus.DROPPED)
            throw new EnrollmentException("Learner already dropped.");
        status = EnrollmentStatus.DROPPED;
    }

    @Override
    public String toString() { return id + " " + name + " " + status; }
}

class Course {
    private static final int CAPACITY = 3;
    private final Learner[] learners = new Learner[CAPACITY];
    private int count = 0;

    public Learner enroll(int id, String name) throws EnrollmentException {
        if (find(id) != null) throw new EnrollmentException("Duplicate learner ID.");
        if (count >= CAPACITY) throw new EnrollmentException("Course is full.");
        Learner l = new Learner(id, name);
        learners[count++] = l;
        return l;
    }

    public Learner drop(int id) throws EnrollmentException {
        Learner l = lookup(id);
        l.drop();
        return l;
    }

    public Learner lookup(int id) throws EnrollmentException {
        Learner l = find(id);
        if (l == null) throw new EnrollmentException("Learner not found.");
        return l;
    }

    public Learner[] getLearners() {
        Learner[] copy = new Learner[count];
        for (int i = 0; i < count; i++) copy[i] = learners[i];
        return copy;
    }

    private Learner find(int id) {
        for (int i = 0; i < count; i++)
            if (learners[i].getId() == id) return learners[i];
        return null;
    }
}

public class Baluyotproblem3 {
    private static final Scanner in = new Scanner(System.in);

    private static int readInt(String prompt) throws EnrollmentException {
        System.out.print(prompt);
        try {
            return Integer.parseInt(in.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new EnrollmentException("Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        Course course = new Course();
        boolean running = true;
        while (running) {
            System.out.println("\nMenu: 1 Enroll | 2 Drop | 3 List | 4 Find | 0 Exit");
            try {
                int choice = readInt("Choice: ");
                switch (choice) {
                    case 1: {
                        int id = readInt("ID: ");
                        System.out.print("Name: ");
                        String name = in.nextLine().trim();
                        System.out.println(course.enroll(id, name).getStatus());
                        break;
                    }
                    case 2:
                        System.out.println(course.drop(readInt("ID: ")).getStatus());
                        break;
                    case 3:
                        for (Learner l : course.getLearners()) System.out.println(l);
                        break;
                    case 4:
                        System.out.println(course.lookup(readInt("ID: ")));
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        throw new EnrollmentException("Invalid menu choice.");
                }
            } catch (EnrollmentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
