package oop.labor04.lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private final String firstName;
    private String lastName;
    private final int birthYear;

    //constructor
    public Person(String fisrtName, String lastName, int birthYear){
        this.firstName = fisrtName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    //getters
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    //setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return  "Name: " + firstName + " " + lastName + "\n" +
                "Birth Year: " + birthYear + "\n";
    }
}
