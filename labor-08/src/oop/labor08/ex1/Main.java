package oop.labor08.ex1;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("OTP");
        bank.addCustomer(new Customer("Arany","Janos"));
        bank.addCustomer(new Customer("Kis","Agnes"));

        Customer c1 = bank.getCustomer(1);
        Customer c2 = bank.getCustomer(2);

        //add accounts to customer 1
        c1.addAccount(new SavingsAccount(0.02));
        c1.addAccount(new CheckingAccount(1000));

        //add accounts to customer 2
        c2.addAccount(new SavingsAccount(0.03));
        c2.addAccount(new CheckingAccount(1000));

        BankAccount c1Savings = c1.getAccounts(0);
        BankAccount c1Checking = c1.getAccounts(1);
        BankAccount c2Savings = c2.getAccounts(0);
        BankAccount c2Checking = c2.getAccounts(1);

        //deposit money in each account
        c1Savings.deposit(1500);
        c1Checking.deposit(1900);
        c2Savings.deposit(2900);
        c2Checking.deposit(1700);

        //print the customers
        System.out.println(c1);
        System.out.println(c2);

        ((SavingsAccount)c1Savings).addInterest();
        ((SavingsAccount)c2Savings).addInterest();

        System.out.println(c1);
        System.out.println(c2);
    }
}
