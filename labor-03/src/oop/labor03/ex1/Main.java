package oop.labor03.ex1;

public class Main {
    public static void main(String[] args) {

        //John
        Customer customer1 = new Customer("John", "BLACK");
        System.out.println(customer1);
        customer1.setAccount(new BankAccount("OTP00001"));
        System.out.println(customer1);
        customer1.getAccount().deposit(1000);
        System.out.println(customer1);


        //Mary
        Customer customer2 = new Customer("Mary", "WHITE");
        customer2.setAccount(new BankAccount("OTP00002"));
        customer2.getAccount().deposit(1500);
        customer2.getAccount().withdraw(400);
        System.out.println(customer2);

        customer2.closeAccount();

        //After marriage
        customer2.setLastName(customer1.getLastName());
        customer2.setAccount(customer1.getAccount());

        System.out.println(customer1 + "\n" + customer2);



    }
}
