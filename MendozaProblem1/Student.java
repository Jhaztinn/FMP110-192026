package com.mycompany.fmp;

/**
 * Standard Student class with validation.
 * @author kvmendoza
 */
public class Student {
    private String name;
    private double grade;
    
    public Student(String name, double grade) throws InvalidGradeException {
        this.name = validateName(name);

        if (grade < 0.0 || grade > 100.0) {
            throw new InvalidGradeException("Error: Grade must be between 0 and 100.");
        }
        this.grade = grade;
    }

    public String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Name cannot be blank.");
        }
        return name;
    }

    public String getName() {
        return this.name;
    }

    public static double validateGrade(String grade) {
    try {
        return Double.parseDouble(grade);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Error: Grade must be a valid number.");
    }
}

    public void setGrade(String grade) throws InvalidGradeException {
        double valGrade = validateGrade(grade); 
        if (valGrade < 0.0 || valGrade > 100.0) {
            throw new InvalidGradeException("Error: Grade must be between 0 and 100.");
        }
        this.grade = valGrade;
    }

    public double getGrade() {
        return this.grade;
    }
}