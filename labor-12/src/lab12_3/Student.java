package lab12_3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Comparable<Student>{
    private final int id;
    private final String firstName;
    private final String lastName;
    private double average;
    private boolean passed;

    private final HashMap<Classes, Double> marks = new HashMap<>();

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        passed = true;
    }

    public void setAverage() {
        double sum = 0;
        int count = marks.size();
        for (Map.Entry<Classes,Double> entry : marks.entrySet()){
            if (entry.getValue() < 5){
                passed = false;
            }
            sum += entry.getValue();
        }
        this.average = (Double)sum / count;
        if (this.average < 6) passed = false;
    }

    public void assignMark(Classes classType, double mark){
        if (marks.get(classType) == null){
            marks.put(classType,mark);
        }
        else{
            marks.replace(classType,mark);
        }
    }

    boolean isPassed(){
        return passed;
    }

    @Override
    public String toString() {
        String res="";
        res += "ID: " + id +
                "\nName: " + lastName + " " + firstName +
                "\nAvg: " + average +
                "\nMarks:\n";

        for (Map.Entry<Classes,Double> entry : marks.entrySet()){
            res += "\t\t" + entry.getKey() + ": " + entry.getValue();
        }

        res += "\nPassed: " + isPassed();
        return res;
    }

    @Override
    public int compareTo(Student student) {
        return (this.firstName +" "+ this.lastName).compareTo(student.firstName + " " + student.lastName);
    }
}
