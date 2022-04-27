package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Apple");
        company.hire(new Manager("Alpar","Reszeg",7000,new MyDate(2001,8,4),"Almaszedes"));


        company.printAll(System.out);

        company.sortByComparator(Comparator.comparing(Employee::getBirthDate));
    }
}
