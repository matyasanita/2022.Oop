package oop.labor05.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Training {
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private ArrayList<Student> enrolledStudents = new ArrayList<>();

    //constructor

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent) {
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;
    }

    public boolean enroll(Student student){
        if (enrolledStudents != null && enrolledStudents.contains(student))
            return false;

        enrolledStudents.add(student);
        return true;
    }

    public Student findStudentById(String id){
        for ( Student s : enrolledStudents ){
            if ( s.getID() == id ) return s;
        }
        System.out.println("Student not found!");
        return null;
    }

    //getters
    public Course getCourse() {
        return course;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int numEnrolled(){
        return enrolledStudents.size();
    }

    public void printToFile(){
        try {
            FileWriter output = new FileWriter("output.csv");
            String res = "Training{" +
                    "course=" + course +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", pricePerStudent=" + pricePerStudent +
                    ", enrolledStudents=" + enrolledStudents +
                    '}';
            output.write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Training{" +
                "course=" + course +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pricePerStudent=" + pricePerStudent +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }

    public void unEnroll(String id){
        for (Student s : enrolledStudents ){
            if (s.getID() == id){
                enrolledStudents.remove(s);
                System.out.println("Student removed from Training!");
            }
        }
    }

}
