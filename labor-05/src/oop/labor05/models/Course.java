package oop.labor05.models;

import java.time.DayOfWeek;

public class Course {
    private final String name;
    private final String description;
    private final int numHours;

    public Course(String name, String description, int numHours) {
        this.name = name;
        this.description = description;
        this.numHours = numHours;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNumHours() {
        return numHours;
    }

    @Override public String toString(){
        String res = "name : " + name + "\ndescription: "
                + description + "\nDuration : " + numHours + "\n";
        return res;
    }
}
