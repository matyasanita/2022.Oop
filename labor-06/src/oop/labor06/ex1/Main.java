package oop.labor06.ex1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        for(int i=0; i<150; i++){
            accounts.add(new BankAccount()) ;
            //System.out.println(accounts.get(i));
        }

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Okos","Julis"));
        customers.add(new Customer("Kupas","Kupan"));
        customers.add(new Customer("Gazos","Geza"));

        customers.get(0).addAccount(new BankAccount());
        customers.get(1).addAccount(new BankAccount());
        customers.get(2).addAccount(new BankAccount());

        //Bank class test
        Bank bank = new Bank("OTP");
        bank.addCustomer(customers.get(0));
        bank.addCustomer(customers.get(1));
        System.out.println(bank.getCustomer(1));

        for ( Customer c : bank.getCustomers() ){
           c.getAccounts(0).deposit(1500);
        }

        System.out.println(bank.getCustomer(2));

        bank.printCustomersToFile("bank_customers.csv");
    }

}
