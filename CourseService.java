/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentenrollmentmanagement;

/**
 *
 * @author mresmenda
 */
public class CourseService {
    private Learner[] learners;
    private int count ;
    
    public CourseService (int capacity){
        this.learners = new Learner[capacity];
        this.count = 0; 
    }
    public void enroll(int id,String name) throws EnrollmentException {
        for (int i = 0; i < count; i++) {
            if (learners [i].getId() == id) {
                throw new EnrollmentException("Duplicate learner ID");
            }
        }
        if (count >= learners.length ){
            throw new EnrollmentException("Course is full.");
        }
        learners [count++] = new Learner(id, name);
    }
    public EnrollmentStatus drop(int id) throws EnrollmentException {
        Learner learner = findLearnerById(id);
        if (learner == null){
            throw new EnrollmentException("Learner not found.");
        }
        if (learner.getStatus()== EnrollmentStatus.DROPPED){
            throw new EnrollmentException("Learner already dropped.");
        }
        learner.setStatus(EnrollmentStatus.DROPPED);
        return learner.getStatus();
    }
    
    public void listLearners(){
        if (count == 0) {
            System.out.println("No leaners Enrolled.");
            return;
        }
        for (int i = 0; i < count; i++){
            System.out.println(learners[i]);
        }
    }
    public Learner find(int id) throws EnrollmentException {
        Learner learner = findLearnerById(id);
        if (learner == null) {
            throw new EnrollmentException("Learner not found");
        }
        return learner;
    }
    private Learner findLearnerById(int id){
        for(int i = 0; i < count; i++){
            if (learners[i].getId() == id) {
                return learners[i];
            }
        }
        return null;
    }
}
