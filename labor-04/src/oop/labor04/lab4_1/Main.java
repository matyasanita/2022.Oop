package oop.labor04.lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ArrayList<Person> personArray = readFromCSVFile("lab4_1_input.csv");
        for ( Person obj : personArray){
            System.out.println(obj);
        }

    }

    public static ArrayList<Person> readFromCSVFile(String fileName){
        ArrayList<Person> persons = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] items = line.split(",");
                String firstName = items[0].trim();
                String lastName = items[1].trim();
                //converting
                int birthYear = Integer.parseInt(items[2].trim());
                persons.add(new Person(firstName, lastName, birthYear));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return persons;
    }
}
