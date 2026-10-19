/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentenrollmentmanagement;

/**
 *
 * @author mresmenda
 */
public class Learner {
    private int id;
    private String name;
    private EnrollmentStatus status;
    
    public Learner(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = EnrollmentStatus.ACTIVE;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
    public EnrollmentStatus getStatus(){
        return status;
    }
    
    public void setStatus(EnrollmentStatus status){
        this.status = status;
    }
    @Override
    public String toString(){
        return id + " - " + name + "(" + status +")";
    }
}
