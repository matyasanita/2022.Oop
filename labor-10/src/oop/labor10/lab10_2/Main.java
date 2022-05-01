package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Apple");
        company.hireAll("employees.csv");

        System.out.println("\n****************************\n");
        company.printAll(System.out);

        System.out.println("\n****************************\n");
        System.out.println("Alphabetically: ");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compareTo(o2);
            }
        });

        company.printAll(System.out);
        System.out.println("\n****************************\n");

        System.out.println("Sort by salary:");
        company.sortByComparator(Comparator.comparing(Employee::getSalary,Comparator.reverseOrder()));
        company.printAll(System.out);
        System.out.println("\n****************************\n");

        System.out.println("Managers followed by employees:");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getClass() == o2.getClass()){
                    return o1.compareTo(o2);
                }
                else{
                    if(o1.getClass() == Manager.class)
                        return -1;
                    return 1;
                }
            }
        });
        company.printAll(System.out);
    }
}
