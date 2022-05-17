package lab12_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bac bacDataBase = Bac.newInstance();
        bacDataBase.readStudentsFromFile();
        bacDataBase.assignMarks();

        System.out.println("Number of students who have:\n" +
                "\t-passed: " + bacDataBase.getPassedStudentsCount() + "\n" +
                "\t-failed: " + bacDataBase.getFailedStudentsCount());

        System.out.println("The list of the students who have failed:");
        bacDataBase.printFailedStudents();

    }


}
