package oop.labor04.lab4_2;

import oop.labor04.lab4_1.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        ArrayList<Customer> customers = readFromCSVFile("lab4_2_input.txt");
        for (Customer obj : customers){
            System.out.println(obj.toString());
        }
    }

    public static ArrayList<Customer> readFromCSVFile(String fileName){
        ArrayList<Customer> customers = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] items = line.split(",");
                String objType = items[0].trim();

                if (objType.equals("Customer")){
                    String firstName = items[1].trim();
                    String lastName = items[2].trim();

                    customers.add(new Customer(firstName,lastName));
                }
                else if(objType.equals("Account")){

                    int customerIndex = customers.size() - 1;

                    String accountNumber = items[1].trim();
                    double balance = Integer.parseInt(items[2].trim());

                    //adding the customer to the ArrayList
                    customers.get(customerIndex).addAccount(new BankAccount(accountNumber));

                    //setting the balance

                    customers.get(customerIndex).getAccount(accountNumber).deposit(balance);
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return customers;
    }

}
