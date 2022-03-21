package oop.labor05;

import oop.labor05.models.Course;
import oop.labor05.models.MyDate;
import oop.labor05.models.Student;
import oop.labor05.models.Training;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Courses test
        ArrayList<Course> course1 = readCourses("courses.csv");
        for (Course c : course1){
            //System.out.println(c);
        }

        //Students test
        ArrayList<Student> student1 = readStudents("students.csv");
        for (Student s : student1){
            //System.out.println(s);
        }

        ArrayList<Training> trainings = new ArrayList<>();
        int trainingIndex = 0;

        //Training test
        for ( Course c : course1 ){
            int enrollIndex = 0;

            Random rand = new Random();
            int price = rand.nextInt(1000) + 1000;

            trainings.add(new Training(c , new MyDate(2022,3,21),new MyDate(2022,3,25), price));

            while (enrollIndex < 10){
                int randStudentIndex = rand.nextInt(student1.size());

                //if the student is not yet enrolled
                Student randStudent = student1.get(randStudentIndex);

                if (trainings.get(trainingIndex).enroll(randStudent)){
                    enrollIndex ++;
                }

            }
            trainingIndex ++;
        }

        for (Student s : student1){
            System.out.println(s.getLastName() + " " + s.getFirstName() );
            String res = "";
            for (Training t : trainings){
                if (t.getEnrolledStudents().contains(s))
                    res += "\t" + t.getCourse().getName() + "," + t.getCourse().getDescription() + "\n";
            }
            System.out.println(res);
        }




    }

    public static ArrayList<Course> readCourses(String fileName) {
        ArrayList<Course> courses = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                String name = items[0].trim();
                String desc = items[1].trim();
                int duration = Integer.parseInt(items[2].trim());


                courses.add(new Course(name, desc, duration));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static ArrayList<Student> readStudents(String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                String id = items[0].trim();
                String lastName = items[1].trim();
                String firstName = items[2].trim();

                students.add(new Student(id, firstName, lastName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
