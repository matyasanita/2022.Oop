package oop.labor06.ex1;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public Customer getCustomer(int customerId){
        for (Customer c : customers){
            if(c.getId() == customerId){
                return c;
            }
        }
        System.out.println("Customer not found!");
        return null;
    }

    public ArrayList<Customer> getCustomers() {return customers;}

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    private void printCustomers( PrintStream ps ){
        ps.println("ID, Firstname, Last name, Number of bank accounts");
        for( Customer customer: customers ){
            ps.println( customer.getId()+", " + customer.getFirstName() +", "+
                    customer.getLastName()+", "+customer.getNumAccounts());
        }
        ps.close();
    }

    public void printCustomersToFile( String filename ){
        try {
            printCustomers( new PrintStream(filename ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCustomersToStdout() {
        printCustomers(System.out);
    }


    }
