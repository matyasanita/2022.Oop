package lab11_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = readStudentsFromCSV();
        createWarningFile(students);
    }

    public static void createWarningFile(ArrayList<Student> students){
        try{
            FileWriter fileWriter = new FileWriter("warning.csv");
            for (Student st : students){
                if (st.getCredits() < 30){
                    fileWriter.write(st.toString());
                }
            }
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Student> readStudentsFromCSV(){
        ArrayList<Student> students = new ArrayList<>();
        try(Scanner sc = new Scanner(new File("students.csv"))) {
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                if (line.isEmpty()) continue;
                String items[] = line.split(",");
                try{
                    String neptunId = items[0].trim();
                    String firstName = items[1].trim();
                    String lastName = items[2].trim();
                    int credits = Integer.parseInt(items[3].trim());
                    int birthyear = Integer.parseInt(items[4].trim());
                    int birthmonth = Integer.parseInt(items[5].trim());
                    int birthday = Integer.parseInt(items[6].trim());
                    students.add(new Student(neptunId,firstName,lastName,credits,birthyear,birthmonth,birthday));
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException){
                    System.out.println("INCOMPLETE LINE: " + line);
                }
                catch (InvalidDateException invalidDate){
                    System.out.println("INVALID DATE: " + line);
                }
                catch (NumberFormatException numberFormatException){
                    System.out.println("NUMBER FORMAT EXCEPTION: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;
        return students;
    }
}
