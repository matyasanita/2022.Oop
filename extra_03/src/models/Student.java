package models;

import enums.Major;

public class Student {
    final String neptunCode;
    final String firstName;
    String lastName;
    Major major;

    public Student(String neptunCode, String firstName, String lastName, Major major){
        this.firstName = firstName;
        this.lastName = lastName;
        this.neptunCode = neptunCode;
        this.major = major;
    }

    @Override public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + " " + lastName + " (" + neptunCode + ")");

        return result.toString();
    }
}
