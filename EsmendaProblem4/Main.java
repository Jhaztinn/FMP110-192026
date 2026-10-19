/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentenrollmentmanagement;

/**
 *
 * @author mresmenda
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseService course = new CourseService(3);
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        
        while (choice != 0) {
            System.out.println("\n Menu: 1 Enroll | 2 Drop | 3 List | 4 Find | 0 Exit");
            System.out.println("Enter Choice:  ");
            
            if (!scanner.hasNextInt()){
                System.out.println("Error: Enter a valid number.");
                scanner.next(); 
                continue;
            }
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            try {
                switch(choice){
                    case 1:
                        System.out.println("Enter ID:  ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Error: Enter a valid number.");
                            scanner.next();
                            break;
                        }
                        int id= scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Enter Name:\n ");
                        String name = scanner.nextLine();
                        course.enroll(id, name);
                        System.out.println("ACTIVE");
                        break;
                    case 2:
                        System.out.println("Enter ID to drop: ");
                        if(!scanner.hasNextInt()) {
                            System.out.println("Error: Enter a valid number.");
                            scanner.next();
                            break;
                        }
                        int dropId= scanner.nextInt();
                        scanner.nextLine();
                        EnrollmentStatus status = course.drop(dropId);
                        System.out.println(status);
                        break;
                    case 3:
                        course.listLearners();
                        break;
                    case 4:
                        System.out.println("Enter ID to find: ");
                        if(!scanner.hasNextInt()) {
                            System.out.println("Error: Enter a valid number");
                            scanner.next();
                            break;
                        }
                        int findId = scanner.nextInt();
                        scanner.nextLine();
                        Learner found = course.find(findId);
                        System.out.println(found);
                        break;
                    case 0:
                        System.out.println("Exiting application.");
                        break;
                    default:
                        System.out.println("Error: Invalid menu choice.");
                }
            }catch (EnrollmentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
