package oop.labor10.lab10_2;

import oop.labor10.lab10_1.DateUtil;
import oop.labor10.lab10_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Company {
    private String name;
    private ArrayList<Employee> employee = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void hire (Employee e){
        if (!employee.contains(e))
            employee.add(e);
    }

    public void hireAll(String fileName){
        try (Scanner sc = new Scanner(new File(fileName))){
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                String elements[] = line.split(" ");
                String firstName = elements[0];
                String lastName = elements[1];
                int salary = Integer.parseInt(elements[2]);
                int year = Integer.parseInt(elements[3]);
                int month = Integer.parseInt(elements[4]);
                int day = Integer.parseInt((elements[5]));
                hire(new Employee(firstName,lastName,salary,new MyDate(year,month,day)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sortByComparator(Comparator<Employee> employeeComparator){
        employee.sort(employeeComparator);
    }

    public void printAll(PrintStream p){
        for(Employee e : employee){
            p.println(e);
        }
    }

    public void fire(int ID){

    }
}
