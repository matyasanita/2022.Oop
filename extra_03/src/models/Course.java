package models;

import java.time.DayOfWeek;
import java.util.Arrays;

public class Course {
    final static int MAX_STUDENTS = 120;
    final public static int MAX_COURSES = 100;
    Teacher teacher;
    String courseID;
    int numberOfCredits;
    int numberOfEnrolledStudents;
    Student[] enrolledStudents;
    DayOfWeek dayOfCourse;

    public Course(String courseID, int numberOfCredits, DayOfWeek dayOfCourse){
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        this.dayOfCourse = dayOfCourse;
        numberOfEnrolledStudents = 0;
        this.enrolledStudents = new Student[MAX_STUDENTS];
    }


    //getters

    public String getCourseID (){
        return courseID;
    }

    public Student[] getEnrolledStudents (){
        return enrolledStudents;
    }

    public int getNumberOfEnrolledStudents() {
        return numberOfEnrolledStudents;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public DayOfWeek getDayOfCourse() {
        return dayOfCourse;
    }

    public void AssignTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public void EnrollStudents(Student student){
        if (numberOfEnrolledStudents < MAX_STUDENTS){
            enrolledStudents[numberOfEnrolledStudents] = student;
            numberOfEnrolledStudents ++;
        }
    }

    public void CancelEnrollmentOfStudents(String neptunCode){
        int studentIndex = 0;
        while (studentIndex < numberOfEnrolledStudents && enrolledStudents[studentIndex].neptunCode != neptunCode ){
            studentIndex ++;
        }
        if (studentIndex < numberOfEnrolledStudents){
            while (studentIndex < numberOfEnrolledStudents - 1){
                enrolledStudents[studentIndex] = enrolledStudents[studentIndex + 1];
                studentIndex ++;
            }
            numberOfEnrolledStudents --;
        }
        else
            System.out.println("Student is not enrolled in the course!");
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Course: " + courseID + ":\n" +
                "\tTeacher:" + teacher +
                "\n\tCredits:" + numberOfCredits +
                "\n\tEnrolled students: " + numberOfEnrolledStudents + "\n");
        for(int i = 0 ; i < numberOfEnrolledStudents ; i++){
            result.append("\t\t" + "-" + enrolledStudents[i] + "\n") ;
        }
        return result.toString();
    }

}
