package com.mycompany.fmp;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        Student[] list = new Student[5];
        int i = 0;

        while (run) {
            System.out.println("\n1. Add | 2. List | 3. Lookup | 0. Exit");
            System.out.print("Choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        if (i >= list.length) {
                            System.out.println("Error: Grade book is full.");
                            break;
                        }

                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Grade: ");
                        double grade = scanner.nextDouble();
                        scanner.nextLine();

                        list[i] = new Student(name, grade);
                    

                        System.out.println("Added " + list[i].getName() + ": " + list[i].getGrade());
                        i++;
                        break;

                    case 2:
                        System.out.println("--- Student List ---");

                        if (i == 0) {
                            System.out.println("No students found.");
                        } else {
                            for (int j = 0; j < i; j++) {
                                System.out.println(
                                    (j + 1) + ". "
                                    + list[j].getName()
                                    + " - "
                                    + list[j].getGrade()
                                );
                            }
                        }
                        break;

                    case 3:
                        if (i == 0) {
                            System.out.println("No students found.");
                            break;
                        }

                        try {
                            System.out.print("Enter Index (1-" + i + "): ");
                            int index = scanner.nextInt();
                            scanner.nextLine();

                            if (index < 1 || index > i) {
                                System.out.println(
                                    "Error: Index is outside the stored records."
                                );
                                break;
                            }

                            System.out.println("--- Student Details ---");
                            System.out.println("Name: " + list[index - 1].getName());
                            System.out.println("Grade: " + list[index - 1].getGrade());

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Enter a valid number.");
                            scanner.nextLine();
                        }
                        break;

                    case 0:
                        System.out.println("Exiting program. Goodbye!");
                        run = false;
                        break;

                    default:
                        System.out.println(
                            "Invalid option. Please choose between 0 and 3."
                        );
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid number.");
                scanner.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();

            } catch (InvalidGradeException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}