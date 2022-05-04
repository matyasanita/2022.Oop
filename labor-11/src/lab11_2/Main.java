package lab11_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    void readStudentsFromCSV(){
        try(Scanner sc = new Scanner(new File("students.csv"))) {
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println("input line:");
                String items[] = line.split(" ");
                try(){
                    String neptunId = items[0].trim();
                    String firstName = items[1].trim();
                    String lastName = items[2].trim();
                    int credits = Integer.parseInt(items[3].trim());
                    int birthyear = Integer.parseInt(items[4].trim());
                    int birthmonth = Integer.parseInt(items[5].trim());
                    int birthday = Integer.parseInt(items[6].trim());
                    Student student = new Student(neptunId,firstName,lastName,credits,birthyear,birthmonth,birthday);
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException){
                    System.out.println("INCOMPLETE LINE: " + line);
                }
                catch (InvalidDateException invalidDate){
                    System.out.println("INVALID DATE");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;
    }
}
