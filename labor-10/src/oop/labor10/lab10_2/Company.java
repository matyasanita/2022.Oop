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
                String elements[] = line.split(",");
                if (line.isEmpty()){
                    continue;
                }

                int length = elements.length;

                String firstName = elements[1].trim();
                String lastName = elements[0].trim();
                int salary = Integer.parseInt(elements[2].trim());
                int year = Integer.parseInt(elements[3].trim());
                int month = Integer.parseInt(elements[4].trim());
                int day = Integer.parseInt((elements[5]).trim());

                //employee
                if (elements.length == 6){
                    hire(new Employee(firstName,lastName,salary,new MyDate(year,month,day)));
                }

                //manager
                else if (elements.length == 7)
                {
                    String department = elements[6].trim();
                    hire(new Manager(firstName,lastName,salary,new MyDate(year,month,day),department));
                }
                else{
                    System.out.println("Incorrect input file\n");
                }

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
        boolean found = false;
        int i = 0;
        while (!found){
            if (employee.get(i).getID() == ID){
                employee.remove(i);
                found = true;
            }
            i++;
        }
    }
}
