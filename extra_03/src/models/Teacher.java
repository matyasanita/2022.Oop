package models;

import enums.Degree;
import enums.Department;

public class Teacher {
    public static int currentNumberOfTeachers = 0;
    String lastName;
    final String firstName;
    Degree degree;
    Department department;
    final int teacherID;

    public Teacher(String lastName, String firstName, Degree degree, Department department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.degree = degree;
        this.department = department;
        currentNumberOfTeachers ++;
        this.teacherID = currentNumberOfTeachers;
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName + " - " + degree + " from " +
                department + " department" ;
    }
}
