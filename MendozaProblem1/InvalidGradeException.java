/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fmp;

/**
 *
 * @author kvmendoza
 */
public class InvalidGradeException extends RuntimeException {
    public InvalidGradeException() {
        super("Error: Enter a valid number.");
    }

    // Constructor that accepts a custom message
    public InvalidGradeException(String message) {
        super(message);
    }
}
