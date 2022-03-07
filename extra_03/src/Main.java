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

    public static void main(String[] args){

        //creating students, teachers and a course

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

        System.out.println("-----------------------------------------------");

        //reading university.cvs
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

        //reading students_enrollment.cvs

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

        //print courses
        int i = 0;
        while (courses[i] != null && i < MAX_COURSES) {
            System.out.println(courses[i]);
            i++;
        }
        System.out.println("-----------------------------------------------");

        //Print all students with a specific major enrolled to a course

        System.out.println("Students of COMPUTER SCIENCE enrolled to NNR7S");
        enrolledStudentsByMajor(Major.COMPUTER_SCIENCE, "NNR7S", courses);

        System.out.println("-----------------------------------------------");

        //Return an array containing all courses which are held by a teacher with a
        //given degree.

        System.out.println("Courses which are held by a teacher with the degree of PROFESSOR:");

        Course[] courseByDegree = coursesByTeacherDegree(Degree.PROFESSOR, courses);
        int j = 0;
        while (j < courseByDegree.length && courseByDegree[j] != null){
            System.out.println(courseByDegree[j].getCourseID());
            j++;
        }

        System.out.println("-----------------------------------------------");

        //Count the number of courses which are held on a given day.

        System.out.println("Number of courses which are held on Monday: " + nrOfCoursesByDay(DayOfWeek.MONDAY, courses));
        System.out.println("-----------------------------------------------");

        //Cancel the enrollment of specific students from all enrolled courses. Use
        //the cancellation.csv file (this file contains a list of students’ neptun
        //code who wants to cancel the enrollment).

        cancelEnrollments("cancellation.csv", courses);
        i = 0;
        while (courses[i] != null && i < MAX_COURSES) {
            System.out.println(courses[i]);
            i++;
        }

        System.out.println("-----------------------------------------------");

    }

    //MAIN METHODS:

    public static void enrolledStudentsByMajor(Major major, String courseID, Course[] courses){

        String ret = "";

        int j = 0;
        while (courses[j] != null && j < MAX_COURSES){
            if(courses[j].getCourseID().equals(courseID)){
                Student[] enrolledStudents = courses[j].getEnrolledStudents();
                for (int i = 0 ; i < courses[j].getNumberOfEnrolledStudents() ; i++){
                    if(enrolledStudents[i].getMajor() == major){
                        ret += "\t" + enrolledStudents[i].toString() + "\n";
                    }
                }
            }
            j++;
        }

        System.out.println("Course : " + courseID + "\nMajor: " + major + "\nStudents: \n" + ret) ;
    }

    public static Course[] coursesByTeacherDegree(Degree degree, Course[] courses){
        int j = 0;

        Course[] coursesArray = new Course[MAX_COURSES];
        int courseIndex = 0;

        while (courses[j] != null && j < courses.length){
            if(courses[j].getTeacher().getDegree() == degree){
                coursesArray[courseIndex] = courses[j];
                courseIndex ++;
            }
            j++;
        }

        return coursesArray;
    }

    public static int nrOfCoursesByDay(DayOfWeek day, Course[] courses) {
        int j = 0;
        int count = 0;

        while (j < courses.length && courses[j] != null){
            if(courses[j].getDayOfCourse() == day){
                count ++;
            }
            j++;
        }

        return count;
    }

    public static void cancelEnrollments(String fileName, Course[] course) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()){
                String neptunCode = sc.nextLine();
                for(Course elem:course){
                    if(elem == null)
                        break;
                    elem.CancelEnrollmentOfStudents(neptunCode);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
