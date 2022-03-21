package oop.labor05.models;

public class Student {
    final String ID;
    final String firstName;
    String lastName;

    //constuctor
    public Student(String ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getters
    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return  "ID = " + ID + '\n' +
                "firstName = " + firstName + '\n' +
                "lastName = " + lastName + '\n';
    }
}
