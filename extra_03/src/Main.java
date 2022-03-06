import enums.Degree;
import enums.Department;
import enums.Major;
import models.Course;
import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Scanner;

import static models.Course.MAX_COURSES;

public class Main {

    public static void enrolledStudentsByMajor(Major major, String courseID, Course[] courses){
        int j = 0;
        while (courses[j] != null){
            if(courses[j].getCourseID().equals(courseID)){

            }
            j++;
        }
    }


    public static void main(String[] args){
        Student student1 = new Student("AVLMO7", "Anne", "Bell", Major.INFORMATION_SCIENCE);
        Student student2 = new Student("UADS18", "Peter", "Parker", Major.HORTICULTURAL_ENGINEERING);
        Student student3 = new Student("FKFO17", "Soma", "Bendeguz", Major.AUTOMATION_AND_APPLIED_INFORMATICS);

        Teacher teacher1 = new Teacher("Suzanne", "Grey", Degree.DOCENT, Department.MATHEMATICS_INFORMATICS);
        Teacher teacher2 = new Teacher("Olga", "Korol", Degree.PROFESSOR, Department.MECHANICAL_ENGINEERING);
        Teacher teacher3 = new Teacher("Erdely", "Laszlo", Degree.ADJUNCT, Department.ELECTRICAL_ENGINEERING);

        Course course1 = new Course("MB_INFO20", 5, DayOfWeek.FRIDAY);

        course1.AssignTeacher(teacher1);
        course1.EnrollStudents(student1);
        course1.EnrollStudents(student2);
        course1.EnrollStudents(student3);

        System.out.println(course1);

        Course[] courses = new Course[MAX_COURSES];
        int courseIndex = 0;

        //read university.cvs
        try {
            Scanner sc = new Scanner(new File("university.csv"));


            while (sc.hasNextLine()){
                String[] courseInfo = sc.nextLine().split(",");
                String[] teacherInfo = sc.nextLine().split(",");

                //course constructor parameters
                String courseID = courseInfo[0];
                int numberOfCredits = Integer.parseInt(courseInfo[1]);
                DayOfWeek dayOfCourse = DayOfWeek.of(Integer.parseInt(courseInfo[2]));

                //teacher constructor parameters

                Department departmentEnum = Department.values()[Integer.parseInt(teacherInfo[3]) - 1];
                Degree degreeEnum = Degree.valueOf(teacherInfo[2]);

                courses[courseIndex] = new Course(courseID, numberOfCredits, dayOfCourse) ;
                courses[courseIndex].AssignTeacher(new Teacher(teacherInfo[0], teacherInfo[1], degreeEnum , departmentEnum ));
                courseIndex ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 50; i++) {
            System.out.println(courses[i]);
        }

        //read students_enrollment.cvs

        try {
            Scanner sc = new Scanner(new File("students.csv"));
            while (sc.hasNextLine()){
                String[] studentInfo = sc.nextLine().split(",");
                String[] enrolledCourses = sc.nextLine().split(",");

                String neptunCode = studentInfo[0];
                String firstName = studentInfo[1];
                String lastName = studentInfo[2];
                Major major = Major.valueOf(studentInfo[3]);

                for (int i = 0; i < enrolledCourses.length; i++) {
                    int j = 0;
                    while (courses[j] != null){
                        if(courses[j].getCourseID().equals(enrolledCourses[i])){
                            courses[j].EnrollStudents(new Student (neptunCode, firstName, lastName, major));
                        }
                        j++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i = 0;
        while (courses[i] != null) {
            System.out.println(courses[i]);
            i++;
        }


    }
}
